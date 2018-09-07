import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

import {LoginService} from "../login.service";
import {Observable} from "rxjs";

export interface Parent {
    id: number;
    name: string;
    account: Account;
    children: Array<Child>;
    school?: string;
}

export interface Account {
  id: number;
  email: string;
  phone?: string;
  password?: string;
}

export interface Child {
    id: number;
    name: string;
    grade: string;
}

//// Like a Meal without a date ======= CheckedChild ou tickedChild ???Like a Meal without a date
export interface TickedChild {
    child: Child;
    ticked: boolean;
}

// For ech day, we have many Ticks available: one per child
export interface TicksByDay {
    day: string,
    ticks: TickedChild[]
}


export interface Meal {
    id: number;
    day: string;
    child: Child;
}

@Injectable({
    providedIn: 'root'
})
export class MealsService {

    constructor(public http: HttpClient, public loginService: LoginService) {
    }

    // activeDay is needed for POSTING a new Meal
    activeDay: string;

    eatableDay: string[] = [];
    childrenByParent: Child[] = [];
    loggedParentId: number = 1;
    //list des tickedChild


    ticker: TicksByDay[] = [];
    mealsParent: Meal[] = [];
    ticked: boolean = false;


    // Should have something with Meal and Date

    getEatableDay() {
        return this.http.get('http://localhost:8585/api/dates/eatableday')
            .toPromise()
            .then((r: any[]) => {
                this.eatableDay = r;
                console.log('Eateable day', this.eatableDay);
                return this.eatableDay;
            })
    }

    createTicker():TicksByDay[]{

        if (this.eatableDay.length === 0){
            console.error('no eatable day');
            return []
        }
        if (this.childrenByParent.length === 0){
            console.error('no child for parent '+this.loginService.idParentLogged);
            return []
        }

        this.ticker = this.eatableDay.map(getDayByTickMapper(this.childrenByParent));

        // Now check who is false or not
        fillTickerWithMeals(this.ticker, this.mealsParent);

        console.log('Ticker created : ', this.ticker);
        return this.ticker;
    }

    getChildrenByParent(parentId) {
        return this.http.get<Child[]>('http://localhost:8585/api/children/parent/' + parentId)
            .toPromise()
            .then(r =>this.childrenByParent = r)
    }


// Not the complete (good) api yet: need to check the meals present in the DB
    // for each case, is it retired or not -> isRetired()


    saveMeal(childId, activeDay) {
        this.http.post(`http://localhost:8585/api/meals/${childId}/${activeDay}`, null)
            .subscribe();
    }

    getMealsByParentId(id) {
        return this.http.get('http://localhost:8585/api/meals/parent/' + id)
            .toPromise()
            .then((r: any[]) => {

                this.mealsParent = r;
                console.log('mealsparent', this.mealsParent);
            }).catch(((error:any) => {
            if (error.status < 400 ||  error.status ===500) {
              return Observable.throw(new Error(error.status));
            }
          }))
    }


    getRetiredChildrenNames(tickedChildList: TickedChild[]) {

        return tickedChildList.filter(tickedChild => tickedChild.ticked)
            .map(c => c.child.name)
    }

    isRetired(childId: number, day: string) {
        return this.mealsParent.some(function (meal) {
            if (meal.child.id === childId && meal.day === day) {
                return true;
            } else {
                return false;
            }
        })
    }


}


function getDayByTickMapper(children: Child[]): (string)=>TicksByDay {

    // this mapper depends on parent children
    return function mapDayByTick(day: string): TicksByDay {

        return {
            day,
            ticks: children.map(child => ({
                child,
                ticked: false
            }))
        }

    }

}


/**
 * Mutative function that will go into the tree
 * and eventually update ticker.ticks[].ticked to true
 */
function fillTickerWithMeals(ticker:TicksByDay[], meals:Meal[]){

    ticker.forEach( (ticksByDay:TicksByDay) =>  {

        meals.forEach(meal => {
            if (meal.day === ticksByDay.day ){
                ticksByDay.ticks.forEach(tick => {
                    if (tick.child.id === meal.child.id){
                        tick.ticked = true;
                    }
                })

            }
        })
    })

}


function mapChildByChildPick(child, day) {
    return {
        child,
        ticked: false
    }
}
