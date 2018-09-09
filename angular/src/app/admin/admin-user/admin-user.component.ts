import {Component, Input, OnInit} from '@angular/core';
import {Admin, AdminUserService} from "./admin-user.service";

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {

  name:string;
  mail:string;
  tel:string;
  pass:string=generate(6);

  constructor(public userService:AdminUserService) {
    userService.getAllAdmins();
  }

  ngOnInit() {
  }

  onSubmit(){
    this.userService.postNewUser(this.name,this.mail,this.tel,this.pass);
    this.name=undefined;
    this.mail=undefined;
    this.tel=undefined;

  }

  createUser(){

  }

  // deleteUser(admin:Admin){
  //   if(!confirm("Sur ?")){
  //     return false;
  //   }
  //   this.userService.deleteAdmin(admin.id, admin.account.id);
  // }

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
