import { Component, OnInit } from '@angular/core';
import {AdminMealsService} from "./admin-meals.service";

@Component({
  selector: 'app-admin-meals',
  templateUrl: './admin-meals.component.html',
  styleUrls: ['./admin-meals.component.css']
})
export class AdminMealsComponent implements OnInit {

  constructor(public service: AdminMealsService) {
    this.service.getNextDays();
    this.service.getMealsByDay();
  }

  ngOnInit() {
  }

  setDates(){
    this.service.updateActiveTab("dates")
  }
  setChildren(){
    this.service.updateActiveTab("children")
  }

}

