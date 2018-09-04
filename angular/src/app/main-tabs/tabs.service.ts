import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TabsService {

  constructor(public http:HttpClient) { }

  activeTab: string = 'accueil';

  updateActiveTab(tabName){
    this.activeTab = tabName;
    console.log("active tab", this.activeTab);
  }




}
