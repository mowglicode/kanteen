import { Component, OnInit } from '@angular/core';
import {AdminMealsService} from "../admin-meals/admin-meals.service";

@Component({
  selector: 'app-admin-meals-dates',
  templateUrl: './admin-meals-dates.component.html',
  styleUrls: ['./admin-meals-dates.component.css']
})
export class AdminMealsDatesComponent implements OnInit {

  constructor( public service: AdminMealsService) { }

  ngOnInit() {
  }

}
