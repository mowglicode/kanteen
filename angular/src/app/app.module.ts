import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenusComponent } from './menus/menus.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { MainTabsComponent } from './main-tabs/main-tabs.component';
import { MealsComponent } from './meals/meals.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCheckboxModule, MatTabsModule} from "@angular/material";
import { AdminMealsDatesComponent } from './admin-meals-dates/admin-meals-dates.component';
import { AdminMealsChildsComponent } from './admin-meals-childs/admin-meals-childs.component';
import { AdminMealsComponent } from './admin-meals/admin-meals.component';


@NgModule({
  declarations: [
    AppComponent,
    MenusComponent,
    MainTabsComponent,
    MealsComponent,
    AdminMealsDatesComponent,
    AdminMealsChildsComponent,
    AdminMealsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatTabsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
