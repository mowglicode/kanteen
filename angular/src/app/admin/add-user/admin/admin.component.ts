import { Component, OnInit } from '@angular/core';

import {Admin, AdminUserService} from "../admin-user.service";
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  name:string;
  mail:string;
  tel:string;
  pass:string=generate(6);

  constructor(public service:AdminUserService) {
    this.service.getAllAdmins();
  }

  ngOnInit() {
  }
  onSubmit(){
    this.service.postNewAdmin(this.name,this.mail,this.tel,this.pass);
    this.name=undefined;
    this.mail=undefined;
    this.tel=undefined;
  }
  createUser(){

  }
}
function generate(taille:number):string{
  let chars:string = "azertyuiopqsdfghjklmwxcvbn123456789";
  let pass:string = "";
  for (let i = 0;i<taille;i++){
    let x:number = Math.floor((Math.random() * chars.length -1));
    pass+=chars.charAt(x);
  }
  return pass;
}
