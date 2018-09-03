import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";


export type Menu = {
  content: string;
}

@Injectable({
  providedIn: 'root'
})
export class MenusService {
  menus: Menu[]=[];


  constructor(public http:HttpClient) {}

  getAllMenus(){
    this.http.get('http://localhost:8585/api/menus')
      .subscribe((r:any[]) => {
      this.menus =r
      console.log(this.menus);
    });
  }


  saveMenu(content){
    let menu:Menu = {
      content:content
    }
    this.http.post('http://localhost:8585/api/menus', menu).subscribe(r => console.log(r));
  }

}
