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
  nextDays: string[]=[];
  numberMealsByDay: number []=[];
  mealsbyDay: Meal[]=[];

  updateActiveTab(tabName) {
    this.activeTab = tabName;
  }


  getNextDays() {
    this.http
      .get('http://localhost:8585/api/dates/week')
      .subscribe((result: any[])=> {
        this.nextDays = result;
        console.log('nextDays', this.nextDays);
      });
  }

  /*
getMealsByDay(){
    this.http
      .get('http://localhost:8585/api/meals/day/'+this.nextDays)//
      .subscribe((r:any[])=>{
        this.mealsbyDay=r;
        console.log('mealsByDay', this.mealsbyDay);

      })
}

getNumbermealsByDay(){
    this.nextDays.forEach(function(day){
      this.mealsbyDay.reduce(function(nbr, meal) {
        return nbr+1;
      },0)
    })


}*/

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
