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


@NgModule({
  declarations: [
    AppComponent,
    MenusComponent,
    MainTabsComponent,
    MealsComponent
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
