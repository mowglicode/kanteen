import { Component, OnInit } from '@angular/core';
import {LoginService} from "../login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  token:any;

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
    console.log("Je suis Olivier");
    this.token = this.service.login(this.user.email, this.user.password);

    this.display(this.token);
  }

  display(r:any){
    console.log("Mon token est :");
    console.log(r);
  }

}
