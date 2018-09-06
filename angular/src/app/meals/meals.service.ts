import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {logging} from "selenium-webdriver";
import {LoginService} from "../login.service";

export interface Parent {
  id: number;
  name: string;
  account: Account;
  children: Array<Child>;
  school?: string;
}
export interface Account {
  id: number;
  email?:string;
  password?:string;
  phone?:string;
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
  day: string;
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

  mailLogged: string = this.loginService.mailLogged;
  parentLogged:Parent = undefined;
  eatableDay: string[] = [];
  childrenByParent: Child[] = [];
  loggedParentId: number = 1;
  //list des tickedChild
  tickedChildList: TickedChild[] = [];
  mealsParent: Meal[] = [];
  ticked: boolean = false;


  // Should have something with Meal and Date

  getEatableDay() {
    this.http.get('http://localhost:8585/api/dates/eatableday')
      .subscribe((r: any[]) => {
        this.eatableDay = r;
        console.log('Eateable day', this.eatableDay);
      });
  }

  getChildrenByParentId(id) {
    this.http.get('http://localhost:8585/api/children/parent/' + id)
      .subscribe((r: any[]) => {
        this.childrenByParent = r;
        console.log('Childrenbyparent', this.childrenByParent);
        this.tickedChildList = this.childrenByParent.map(mapChildByChildPick)

      })
  }

  getParentByEmail(email: string) {
    this.http.get('http://localhost:8585/api/parents/email/' + email)
      .subscribe((r: any) => {
        this.parentLogged=r;
      })

  }



// Not the complete (good) api yet: need to check the meals present in the DB
  // for each case, is it retired or not -> isRetired()
  DbmealsIsOk() {


  }


  saveMeal(childId, activeDay) {
    this.http.post(`http://localhost:8585/api/meals/${childId}/${activeDay}`, null)
      .subscribe();
  }

  getMealsByParentId(id) {
    this.http.get('http://localhost:8585/api/meals/parent/' + id)
      .subscribe((r: any[]) => {
        this.mealsParent = r;
        console.log('mealsparent', this.mealsParent);
      })
    return this.mealsParent;
  }


  getRetiredChildrenNames() {
    return this.tickedChildList.filter(tickedChild => tickedChild.ticked)
      .map(c => c.child.name)
  }

  isRetired(childId: number, day: string) {
    this.mealsParent.forEach(function (meal) {
      if (meal.child.id === childId && meal.day === day) {
        return true;
      } else {
        return false;
      }
    })
  }


}
function mapParent(parent:any):Parent{
  return {
    id:parent.id,
    name:parent.name,
    children:parent.child,
    account:parent.account,
    school:parent.school
  }
}
function mapChildByChildPick(child, day): TickedChild {
  return {
    child,
    ticked: false,
    day,
  }
}
