import { Component, OnInit } from '@angular/core';
import {AdminMealsService} from "../admin-meals/admin-meals.service";

@Component({
  selector: 'app-admin-meals-childs',
  templateUrl: './admin-meals-childs.component.html',
  styleUrls: ['./admin-meals-childs.component.css']
})
export class AdminMealsChildsComponent implements OnInit {

  constructor(public service: AdminMealsService) {


  }

  ngOnInit() {
  }

}
