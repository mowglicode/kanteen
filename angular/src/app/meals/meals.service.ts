import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";






@Injectable({
  providedIn: 'root'
})
export class MealsService {

  constructor(public http: HttpClient) {
  }

  eatableDay : string[] = [];


  getEatableDay() {
    this.http.get('http://localhost:8585/api/dates/eatableday')
      .subscribe((r: any[]) => {
        this.eatableDay = r
        console.log(this.eatableDay);
      });
  }

}
