import { Component, OnInit } from '@angular/core';
import {Information, HomeService} from "./home.service";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  id:number;
  description:string;
  expiry:string;
  hasExpiration:boolean;

  constructor(public service: HomeService) {
  }

  ngOnInit() {
    this.showAllInformation();
  }

  showAllInformation() {
    this.service.getAllInformations();
  }
}
