import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AdminMealsService {

  constructor(public http:HttpClient) { }

activeTab: string = 'dates';

  updateActiveTab(tabName){
    this.activeTab = tabName;
  }




}
