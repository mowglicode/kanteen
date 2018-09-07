import { Component, OnInit } from '@angular/core';
import {HomeService} from "../../home/home.service";
import {AdminHomeService} from "./admin-home.service";

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  id:number;
  description:string;
  expiry:string;
  hasExpiration:boolean;

  constructor(public service: AdminHomeService) {
  }

  ngOnInit() {
    this.showAllInformation();
  }

  showAllInformation() {
    this.service.getAllInformations();
  }

}
