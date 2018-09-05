import { Component, OnInit } from '@angular/core';
import {Menu, MenusService} from './menus.service';

@Component({
  selector: 'app-menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})
export class MenusComponent implements OnInit {

  content: string;
  id: number;
  week:number;

  constructor(public service: MenusService) {
    service.getAllMenus();
    //service.getMenuById(id);


  }

  ngOnInit() {
  }


  getMenuById(){
  //  this.service.getMenuById(17);
    return this.service.menu;
  }

}
