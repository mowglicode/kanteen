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
  MatExpansionModule,
  MatFormFieldModule,
  MatIconModule,
  MatListModule,
  MatMenuModule,
  MatTableDataSource,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatCheckboxModule, MatInputModule
} from "@angular/material";
import { MenuAdminComponent } from './admin/menu-admin/menu-admin.component';
import { HomeComponent } from './home/home.component';
import { AdminMealsDatesComponent } from './admin/admin-meals-dates/admin-meals-dates.component';
import { AdminMealsChildsComponent } from './admin/admin-meals-childs/admin-meals-childs.component';
import { AdminMealsComponent } from './admin/admin-meals/admin-meals.component';
import { DataComponent } from './data/data.component';
import { AdminMainTabsComponent } from './admin/admin-main-tabs/admin-main-tabs.component';
import {LoginComponent} from "./login/login.component";
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';


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
    DataComponent,
    AdminMainTabsComponent,
    LoginComponent,
    AdminHomeComponent
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
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
