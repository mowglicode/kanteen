import { Component, OnInit } from '@angular/core';
import {MenusService, Menu} from "../../menus/menus.service";
import {MatDialog, MatDialogRef} from "@angular/material";


@Component({
  selector: 'app-menu-admin',
  templateUrl: './menu-admin.component.html',
  styleUrls: ['./menu-admin.component.css']
})
export class MenuAdminComponent implements OnInit {

  content: string;
  id: number;
  week: number = null;
  edit: boolean = false;
  modifiedContent:string;
  modifiedWeek:number;

  constructor(public service: MenusService, public dialog:MatDialog) {
    service.getAllMenus();
  }

  ngOnInit() {
  }


  onSubmit() {
    this.service.saveMenu(this.content, this.week);
    console.log(this.content, this.week);
    this.content = null;
    this.week = null;

  }

  onDelete(menu: Menu) {
    this.service.deleteMenu(menu);
  }

  onEdit(menu) {
    this.edit = !this.edit;
    if (this.edit){
      this.modifiedContent = menu.content;
      this.modifiedWeek = menu.week;
    }
  }

  modify(id:number) {
    this.service.editMenu(id, this.modifiedContent, this.modifiedWeek)
  }



}
