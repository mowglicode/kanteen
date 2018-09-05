import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";



export interface Child {
  id:number;
  name:string;
  grade:string;
}




@Injectable({
  providedIn: 'root'
})
export class MealsService {

  constructor(public http: HttpClient) {
  }

  eatableDay : string[] = [];
  childrenByParent: string[]=[];
  loggedParentId :number=1;

  getEatableDay() {
    this.http.get('http://localhost:8585/api/dates/eatableday')
      .subscribe((r: any[]) => {
        this.eatableDay = r;
        console.log(this.eatableDay);
      });
  }

  getChildrenByParentId(id){
    this.http.get('http://localhost:8585/api/children/parent/'+ id)
      .subscribe((r:any[])=>{
        this.childrenByParent=r;
        console.log(this.childrenByParent);
      })


  }

}
