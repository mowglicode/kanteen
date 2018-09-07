import { Component, OnInit } from '@angular/core';
import {PrivacyAdminService} from "../privacy-admin.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-privacy-admin',
  templateUrl: './privacy-admin.component.html',
  styleUrls: ['./privacy-admin.component.css']
})
export class PrivacyAdminComponent implements OnInit {

  title : string ;
  description:string;

  constructor(public service:PrivacyAdminService, public http:HttpClient) {
    this.service.fetchContract();
  }

  ngOnInit() {
  }
  onSubmit(){
    this.service.saveContract(this.title,this.description);
  }
}
