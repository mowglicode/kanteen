import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class DataService {

  constructor(public http: HttpClient) { }

  createDatabase(){
    console.log("Je suis passé par là")
    this.http.get("http://localhost:8585/api/dbcreate").subscribe();
  }
}
