import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenusComponent } from './menus/menus.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { MainTabsComponent } from './main-tabs/main-tabs.component';
import { MealsComponent } from './meals/meals.component';
import {
  MatButtonModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatIconModule,
  MatListModule,
  MatMenuModule,
  MatTableDataSource,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatCheckboxModule, MatSelectModule
} from "@angular/material";
import { MenuAdminComponent } from './admin/menu-admin/menu-admin.component';
import { HomeComponent } from './home/home.component';

import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import { PrivacyComponent } from './privacy/privacy.component';
import { DataComponent } from './data/data.component';
import { AdminMainTabsComponent } from './admin/admin-main-tabs/admin-main-tabs.component';
import {AdminMealsDatesComponent} from './admin/admin-meals-dates/admin-meals-dates.component';
import {AdminMealsChildsComponent} from "./admin/admin-meals-childs/admin-meals-childs.component";
import {AdminMealsComponent} from "./admin/admin-meals/admin-meals.component";
import { PrivacyAdminComponent } from './admin/privacy-admin/privacy-admin.component';


@NgModule({
  declarations: [
    AppComponent,
    MenusComponent,
    MainTabsComponent,
    MealsComponent,
    PrivacyComponent,
    MealsComponent,
    MenuAdminComponent,
    MealsComponent,
    AdminMealsDatesComponent,
    AdminMealsChildsComponent,
    AdminMealsComponent,
    MealsComponent,
    HomeComponent,
    DataComponent,
    AdminMainTabsComponent,
    PrivacyAdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatListModule,
    MatTabsModule,
    MatExpansionModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatTabsModule,
    FormsModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule0
  bootstrap: [AppComponent]
})
export class AppModule { }
