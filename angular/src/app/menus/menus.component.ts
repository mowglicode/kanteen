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
    // alert('pouet');
    service.getAllMenus();
    //service.getMenuById(id);


  }

  ngOnInit() {
  }


  onSubmit(){
    this.service.saveMenu(this.content, this.week);
  }

  onDelete(menu:Menu){
    this.service.deleteMenu(menu);
  }

  getMenuById(){
  //  this.service.getMenuById(17);
    return this.service.menu;
  }

}
