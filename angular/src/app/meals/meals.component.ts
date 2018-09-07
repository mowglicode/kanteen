import {Component, Input, OnInit} from '@angular/core';
import {Child, MealsService, TickedChild} from "./meals.service";
import {forEach} from "../../../node_modules/@angular/router/src/utils/collection";
import {bind} from "../../../node_modules/@angular/core/src/render3/instructions";


@Component({
    selector: 'app-meals',
    templateUrl: './meals.component.html',
    styleUrls: ['./meals.component.css']
})
export class MealsComponent implements OnInit {

    //checked=false;

    @Input() child: Child


    childId: number = undefined;
    // mealCheck= object = map  key value de type any
    mealCheck: any = {}

    tickedChildList: TickedChild[] = [];

    constructor(public service: MealsService) {
        /**
         * Getting first children,
         * then all meals,
         * then eatable days
         * then constructing the ticker
         */
        this.service.getChildrenByParent(this.service.loggedParentId)
            .then(() => this.service.getMealsByParentId(this.service.loggedParentId))
            .then(() => this.service.getEatableDay())
            .then( () => this.service.activeDay = this.service.eatableDay[0])
            .then(() => this.service.createTicker())

    }

    ngOnInit() {
    }

    fetchParentId(){
    console.log("mail logged :"+this.service.mailLogged);
    this.service.getParentByEmail(this.service.mailLogged);
    console.log("parent ID logged :"+this.service.loggedParentId);
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

    format(day: string): string {
        let date = new Date();
        date.setFullYear(parseInt(day.slice(0, 4)));
        date.setUTCMonth(parseInt(day.slice(5, 7)) - 1); // Month starts at 0 !
        date.setUTCDate(parseInt(day.slice(8, 11))); // day of the month, starts at 1
        // console.log(date);
        return `${this.getLabelDay(date.getDay())} ${date.getDate()}-${date.getMonth() + 1}  `;
    }

    tabSelection(event) {

        console.log(event, "tab index=", event.index);
        this.service.activeDay = this.service.eatableDay[event.index];

        console.log("Activeday >" , this.service.activeDay);


        this.tickedChildList = this.service.childrenByParent
            .map(child => ({child, ticked:false}));


    }

    isRetired(child:Child, day:string){

        let res =  this.service.isRetired(child.id, day);
        // console.log(child.name, day, res);
        return res;
    }

    childSelection(event) {
        console.log(event, event.source.value, event.checked);
        // this.activeDay=event.source.name;
        // console.log("#Activeday?"+this.activeDay);

        // childId prend la valeur de "value"(c.id) de l'event click une checkbox
        this.childId = event.source.value;
        //l'element de mealCheck avec la cle: event.source.value (=child id)
        // prend la valeur true ou false qui depend de l'évenement click la checkbox (si elle est checked ou pas)
        this.mealCheck[event.source.value] = event.checked;//???question nico
        console.log(this.mealCheck);


        //deuxieme version pour gérer aussi de checker les checkbox qui correspondent déjà à un meal de la dataBase

        //childPickList= liste des tickedChild

        // recupère le tickedChild (type TickedChild) qui a le child qui a l'id égale au child id de la checkbox qui est checked
        let tickedChild = this.tickedChildList.find(tickedChild => tickedChild.child.id === event.source.value);

        // attribue la valeur true ou false en fonction de si la checkbox est checked au booleen picked du ChildPick childPick
        tickedChild.ticked = event.checked;


        console.log("tickedChild=", tickedChild);
        console.log("childname=", tickedChild.child.name);//???? toujours le dernier clicke, checked ou non!!!
        console.log("tiked?=", tickedChild.ticked);

        //called when check a checkbox
        /* let  mealsDayChild = this.service.getMealsByParentId(this.service.loggedParentId)
           .filter(function (meal){return meal.day;})
           .filter(function (meal) {return meal.child_id;})
     */
    }

    getRetiredChildrenNames(){
        return this.service.getRetiredChildrenNames(this.tickedChildList);
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
        console.log('Active day: ', this.service.activeDay);
        this.service.saveMeal(this.childId, this.service.activeDay);
    }

}
