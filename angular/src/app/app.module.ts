import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MenusComponent} from './menus/menus.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {MainTabsComponent} from './main-tabs/main-tabs.component';
import {MealsComponent} from './meals/meals.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatButtonModule,
  MatCheckboxModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatTableDataSource,
  MatOptionModule,
  MatSelectModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule
} from "@angular/material";
import {AdminMealsDatesComponent} from './admin/admin-meals-dates/admin-meals-dates.component';
import {AdminMealsChildsComponent} from "./admin/admin-meals-childs/admin-meals-childs.component";
import {AdminMealsComponent} from "./admin/admin-meals/admin-meals.component";
import { MenuAdminComponent } from './admin/menu-admin/menu-admin.component';
import { HomeComponent } from './home/home.component';
import { DataComponent } from './data/data.component';
import { AdminMainTabsComponent } from './admin/admin-main-tabs/admin-main-tabs.component';
import {PrivacyComponent} from "./privacy/privacy.component";
import {AdminHomeComponent} from "./admin/admin-home/admin-home.component";
import {LoginComponent} from "./login/login.component";
import {PrivacyAdminComponent} from "./admin/privacy-admin/privacy-admin.component";


@NgModule({
  declarations: [
    AdminHomeComponent,
    AdminMainTabsComponent,
    AdminMealsChildsComponent,
    AdminMealsComponent,
    AdminMealsDatesComponent,
    AppComponent,
    DataComponent,
    HomeComponent,
    LoginComponent,
    MainTabsComponent,
    MenusComponent,
    MealsComponent,
    MenuAdminComponent,
    PrivacyComponent,
    PrivacyAdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatIconModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatTabsModule,
    MatSelectModule,
    MatTableModule,
    MatTabsModule,
    MatIconModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
