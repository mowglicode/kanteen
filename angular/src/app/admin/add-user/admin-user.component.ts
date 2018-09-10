import {Component, Input, OnInit} from '@angular/core';
import {Admin, AdminUserService} from "./admin-user.service";

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {



  constructor(public userService:AdminUserService) {
    userService.getAllAdmins();
  }

  ngOnInit() {
  }

}
