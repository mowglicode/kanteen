import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenusComponent } from './menus/menus.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { MainTabsComponent } from './main-tabs/main-tabs.component';
import { MealsComponent } from './meals/meals.component';


@NgModule({
  declarations: [
    AppComponent,
    MenusComponent,
    MainTabsComponent,
    MealsComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
