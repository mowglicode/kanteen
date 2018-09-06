import {Component, Input, OnInit} from '@angular/core';
import {Child, MealsService} from "./meals.service";




@Component({
  selector: 'app-meals',
  templateUrl: './meals.component.html',
  styleUrls: ['./meals.component.css']
})
export class MealsComponent implements OnInit {

  checked=false;

  @Input() child:Child

  constructor(public service:MealsService) {
    this.service.getEatableDay();
    this.service.getChildrenByParentId(service.loggedParentId);
  }

  /*
  setMeal(){
    this.service.postMeals()
  }
  */

  ngOnInit() {
  }

  activeDay:string="";
  childId:number=undefined;
  mealCheck:any= {}

  dayTabSelection(event){
    console.log(event, event.tab.textLabel);
    this.activeDay=event.tab.textLabel;
    console.log(this.activeDay);
  }

  childSelection(event){
    console.log(event, event.source.value, event.checked);
    this.childId= event.source.value;
    this.mealCheck[event.source.value]= event.checked;//???question nico
    console.log(this.mealCheck);


    let picks = this.service.picks;
    let childPick = picks.find(childPick => childPick.child.id === event.source.value );
    childPick.picked = event.checked;
    console.log(picks);


  }

  /* Open when someone clicks on the span element */
  openNav() {
    document.getElementById("myNav").style.width = "100%";
  }

  /* Close when someone clicks on the "x" symbol inside the overlay */
  closeNav() {
    document.getElementById("myNav").style.width = "0%";
  }


//TODO retirer  le / de la date
postMeal(){
    this.service.saveMeal(this.childId, this.activeDay);
  console.log('xxx',this.activeDay);
}

}
