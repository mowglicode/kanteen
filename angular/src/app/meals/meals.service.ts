import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";


export interface Child {
  id: number;
  name: string;
  grade: string;
}

// Like a Meal without a date
export interface tickedChild {
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
  tickedChildList: tickedChild[] = [];
  mealsParent: Meal[] = [];


  // Should have something with Meal and Date

  getEatableDay() {
    this.http.get('http://localhost:8585/api/dates/eatableday')
      .subscribe((r: any[]) => {
        this.eatableDay = r;
        console.log(this.eatableDay);
      });
  }

  getChildrenByParentId(id) {
    this.http.get('http://localhost:8585/api/children/parent/' + id)
      .subscribe((r: any[]) => {
        this.childrenByParent = r;
        console.log(this.childrenByParent);

        // Not the good api yet
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
        console.log(this.mealsParent);
      })
  return this.mealsParent;
  }


}


function mapChildByChildPick(child): tickedChild {
  return {
    child,
    ticked: false
  }
}
