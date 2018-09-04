import { Component, OnInit } from '@angular/core';
import {Contract, PrivacyService} from "../privacy.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-privacy',
  templateUrl: './privacy.component.html',
  styleUrls: ['./privacy.component.css']
})
export class PrivacyComponent implements OnInit {

  body : Contract ;
  comment:string;

  constructor(public service:PrivacyService, public http:HttpClient) {
    this.service.fetchContract();
  }

  ngOnInit() {
  }

  onSubmit(){
    this.http.post('http://localhost:8080/api/admin/privacy/contracts', this.body);
  }
}
