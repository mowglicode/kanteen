import { Component, OnInit } from '@angular/core';
import {LoginService} from "../login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user ={
    email: "o@g.com",
    password:"zzz",
  }

  constructor(public service:LoginService) { }

  ngOnInit() {
  }

  onSubmit(){
    console.log(this.user.email);
    console.log(this.user.password);
    this.service.checkLoginStatus(this.user.email, this.user.password);
  }

  isAdmin(){
    console.log("Admin :" + this.service.isAdmin);
    return this.service.isAdmin;
  }

  isLogged(){
    console.log("Loggué"+this.service.isLogged);
    return this.service.isLogged;
  }

}
