import {Component, OnInit} from '@angular/core';
import {TabsService} from "./tabs.service";

@Component({
  selector: 'app-main-tabs',
  templateUrl: './main-tabs.component.html',
  styleUrls: ['./main-tabs.component.css']
})
export class MainTabsComponent implements OnInit {

  constructor(public service: TabsService) {
  }

  ngOnInit() {
    this.service.updateActiveTab("home")
  }

  setHome() {
    this.service.updateActiveTab("home")
  }

  setMeals() {
    this.service.updateActiveTab("meals")
  }

  setMenus() {
    this.service.updateActiveTab("menus")
  }

  setPrivacy() {
    this.service.updateActiveTab("privacy")
  }

}
