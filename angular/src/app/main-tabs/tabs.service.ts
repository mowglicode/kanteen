import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TabsService {

  constructor(public http:HttpClient) { }

  activeTab: string = 'home';







}
