import { Component, OnInit } from '@angular/core';
import {MealsService} from "./meals.service";

@Component({
  selector: 'app-meals',
  templateUrl: './meals.component.html',
  styleUrls: ['./meals.component.css']
})
export class MealsComponent implements OnInit {

  constructor(public service:MealsService) {
    this.service.getEatableDay();
  }

  ngOnInit() {
  }



  }
