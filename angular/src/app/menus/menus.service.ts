import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";


export type Menu = {
  id?:number
  content: string;
}

@Injectable({
  providedIn: 'root'
})
export class MenusService {
  menus: Menu[] = [];
  menu : Menu ;


  constructor(public http:HttpClient) {}

  getAllMenus(){
    this.http.get('http://localhost:8585/api/menus')
      .subscribe((r:any[]) => {
      this.menus = r
      console.log(this.menus);
    });
  }
  getMenuById(id:number){
    this.http.get('http://localhost:8585/api/menus/'+id)
      .subscribe((r:any) => {
        this.menu = r
        console.log(this.menu);
      });
  }

  saveMenu(content:string){
    let body:Menu = {
      content: content
    }
    this.http.post('http://localhost:8585/api/menus', body)
      .subscribe((r:any) => {
        this.menus.push(r)
        console.log(this.menus);
      });
  }

  deleteMenu(menu:Menu){
    let id  = menu.id
    this.http.delete('http://localhost:8585/api/menus/'+id)
      .subscribe();
    var index = this.menus.indexOf(menu);
    this.menus.splice(index, 1);

  }




}
