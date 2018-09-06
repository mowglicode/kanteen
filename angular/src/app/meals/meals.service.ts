import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";


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


export interface Meal {
  id: number;
  day: string;
  child_id: number;
}


@Injectable({
  providedIn: 'root'
})
export class MealsService {

  constructor(public http: HttpClient) {
  }

  eatableDay: string[] = [];
  childrenByParent: Child[] = [];
  loggedParentId: number = 1;
  //list des tickedChild
  tickedChildList: TickedChild[] = [];
  mealsParent: Meal[] = [];


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

// Not the complete (good) api yet: need to check the meals present in the DB
        this.tickedChildList = this.childrenByParent.map(mapChildByChildPick)
      })
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


  getRetiredChildrenNames(){
    return this.tickedChildList.filter(tickedChild => tickedChild.ticked )
      .map(c => c.child.name)
  }



}


function mapChildByChildPick(child): TickedChild {
  return {
    child,
    ticked: false
  }
}
