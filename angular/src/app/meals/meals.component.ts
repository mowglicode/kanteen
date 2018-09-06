import {Component, Input, OnInit} from '@angular/core';
import {Child, MealsService, TickedChild} from "./meals.service";


@Component({
  selector: 'app-meals',
  templateUrl: './meals.component.html',
  styleUrls: ['./meals.component.css']
})
export class MealsComponent implements OnInit {

  //checked=false;

  @Input() child: Child

  activeDay: string = "";
  childId: number = undefined;
  // mealCheck= object = map  key value de type any
  mealCheck: any = {}

  idParentLogged:number = this.service.getParentByEmail(this.service.mailLogged).id;

  constructor(public service: MealsService) {
    this.service.getEatableDay();
    this.service.getChildrenByParentId(this.service.loggedParentId);
    this.service.getMealsByParentId(this.service.loggedParentId);
  }

  ngOnInit() {
  }

  getLabelDay(i:number):string{
    var d = new Date();
    var weekday = new Array(7);
    weekday[0] =  "Dimanche";
    weekday[1] = "Lundi";
    weekday[2] = "Mardi";
    weekday[3] = "Mercredi";
    weekday[4] = "Jeudi";
    weekday[5] = "Vendredi";
    weekday[6] = "Samedi";

    return weekday[i];
  }

  format(day: string):string {
    let date = new Date();
    date.setFullYear(parseInt(day.slice(0, 4)));
    date.setUTCMonth(parseInt(day.slice(5, 7)) - 1); // Month starts at 0 !
    date.setUTCDate(parseInt(day.slice(8, 11))); // day of the month, starts at 1
    // console.log(date);
    return `${this.getLabelDay(date.getDay())} ${date.getDate()}-${date.getMonth() + 1}  `;
  }



  childSelection(event) {
    console.log(event, event.source.value, event.checked);
    console.log("#day?"+ event.source.name);
    this.activeDay=event.source.name;
    console.log("#Activeday?"+this.activeDay);

    // childId prend la valeur de "value"(c.id) de l'event click une checkbox
    this.childId = event.source.value;
    //l'element de mealCheck avec la cle: event.source.value (=child id)
    // prend la valeur true ou false qui depend de l'évenement click la checkbox (si elle est checked ou pas)
    this.mealCheck[event.source.value] = event.checked;//???question nico
    console.log(this.mealCheck);


    //deuxieme version pour gérer aussi de checker les checkbox qui correspondent déjà à un meal de la dataBase

    //childPickList= liste des tickedChild
    let tickedChildList = this.service.tickedChildList;

    // recupère le tickedChild (type TickedChild) qui a le child qui a l'id égale au child id de la checkbox qui est checked
    let tickedChild = tickedChildList.find(tickedChild => tickedChild.child.id === event.source.value);

    // attribue la valeur true ou false en fonction de si la checkbox est checked au booleen picked du ChildPick childPick
    tickedChild.ticked = event.checked;


    console.log(tickedChildList);
    console.log(tickedChild);
    console.log(tickedChild.child.name);//???? toujours le dernier clicke, checked ou non!!!
    console.log(tickedChild.ticked);

    //called when check a checkbox
    /* let  mealsDayChild = this.service.getMealsByParentId(this.service.loggedParentId)
       .filter(function (meal){return meal.day;})
       .filter(function (meal) {return meal.child_id;})
 */
  }

  /* Open when someone clicks on the span element */
  openNav() {
    document.getElementById("myNav").style.width = "100%";
  }

  /* Close when someone clicks on the "x" symbol inside the overlay */
  closeNav() {
    document.getElementById("myNav").style.width = "0%";
  }


  postMeal() {
    this.service.saveMeal(this.childId, this.activeDay);
    console.log('xxx', this.activeDay);
  }

}
