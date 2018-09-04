import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenusComponent } from './menus/menus.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { MainTabsComponent } from './main-tabs/main-tabs.component';
import { MealsComponent } from './meals/meals.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import {
  MatButtonModule,
  MatExpansionModule, MatIconModule,
  MatListModule,
  MatMenuModule,
  MatTabsModule,
  MatToolbarModule, MatCheckboxModule
} from "@angular/material";
import { MenuAdminComponent } from './menus/menu-admin/menu-admin.component';
import { HomeComponent } from './home/home.component';
import { AdminMealsDatesComponent } from './admin-meals-dates/admin-meals-dates.component';
import { AdminMealsChildsComponent } from './admin-meals-childs/admin-meals-childs.component';
import { AdminMealsComponent } from './admin-meals/admin-meals.component';
import { DataComponent } from './data/data.component';


@NgModule({
  declarations: [
    AppComponent,
    MenusComponent,
    MainTabsComponent,
    MealsComponent,
    MenuAdminComponent,
    MealsComponent,
    AdminMealsDatesComponent,
    AdminMealsChildsComponent,
    AdminMealsComponent,
    MealsComponent,
    HomeComponent,
    DataComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatListModule,
    MatTabsModule,
    MatExpansionModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatCheckboxModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
