import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Meal} from "../../meals/meals.service";


@Injectable({
  providedIn: 'root'
})
export class AdminMealsService {

  constructor(public http: HttpClient) {
  }

  activeTab: string = 'dates';
  nextDays: string[] = [];
  mealsbyDay: Meal[] = [];
  meals: Meal[] = [];

  updateActiveTab(tabName) {
    this.activeTab = tabName;
  }


  getNextDays() {
    this.http
      .get('http://localhost:8585/api/dates/week')
      .subscribe((result: any[]) => {
        this.nextDays = result;
        console.log('nextDays', this.nextDays);
      });
  }


  getMeals() {
    this.http
      .get('http://localhost:8585/api/meals/')//
      .subscribe((r: any[]) => {
        this.meals = r;
        console.log('allmeals', this.meals);

      })
  }


  getNumberMealsByDay() {
    var that = this;
    let result = this.nextDays.map(function (day) {
      return {
        day,
        number: that.meals.filter(meal => meal.day === day).length
      }
    });


    return result;

  }

  /*
     getMealsByParent(id) {
          return this.http.get('http://localhost:8585/api/meals/parent/' + id)
              .toPromise()
              .then((r: any[]) => {

                  this.mealsParent = r;
                  console.log('mealsparent', this.mealsParent);
              })
      }*/


}
