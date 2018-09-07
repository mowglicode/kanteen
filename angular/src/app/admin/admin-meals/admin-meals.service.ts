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

  updateActiveTab(tabName) {
    this.activeTab = tabName;
  }

/*
   getMealsByParent(id) {
        return this.http.get('http://localhost:8585/api/meals/parent/' + name)
            .toPromise()
            .then((r: any[]) => {

                this.mealsParent = r;
                console.log('mealsparent', this.mealsParent);
            })
    }*/


}
