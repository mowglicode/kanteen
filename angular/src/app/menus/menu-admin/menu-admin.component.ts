import { Component, OnInit } from '@angular/core';
import {Menu, MenusService} from "../menus.service";

@Component({
  selector: 'app-menu-admin',
  templateUrl: './menu-admin.component.html',
  styleUrls: ['./menu-admin.component.css']
})
export class MenuAdminComponent implements OnInit {

  content: string;
  id: number;
  week: number

  constructor(public service: MenusService) {
    service.getAllMenus();
  }

  ngOnInit() {
  }

modifyContent(){

}
  onSubmit(){
    this.service.saveMenu(this.content, this.week);
    console.log(this.content, this.week);
  }

  onDelete(menu:Menu){
    this.service.deleteMenu(menu);
  }



}
