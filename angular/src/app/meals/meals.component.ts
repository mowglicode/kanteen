import {Component, Input, OnInit} from '@angular/core';
import {Child, MealsService} from "./meals.service";

@Component({
  selector: 'app-meals',
  templateUrl: './meals.component.html',
  styleUrls: ['./meals.component.css']
})
export class MealsComponent implements OnInit {

  @Input() child:Child

  constructor(public service:MealsService) {
    this.service.getEatableDay();
    this.service.getChildrenByParentId(service.loggedParentId);
  }

  ngOnInit() {
  }



  }
