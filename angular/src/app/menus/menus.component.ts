import { Component, OnInit } from '@angular/core';
import {MenusService} from "./menus.service";

@Component({
  selector: 'app-menus',
  templateUrl: './menus.component.html',
  styleUrls: ['./menus.component.css']
})
export class MenusComponent implements OnInit {

  constructor(public service: MenusService) {
    service.getAllMenus();
  }

  ngOnInit() {
  }

}
