import { Component, OnInit } from '@angular/core';
import {Contract, PrivacyService} from "../../privacy.service";
import {HttpClient} from "../../../../node_modules/@angular/common/http";
import {Options, PrivacyAdminService} from "../privacy-admin.service";

@Component({
  selector: 'app-privacy-admin',
  templateUrl: './privacy-admin.component.html',
  styleUrls: ['./privacy-admin.component.css']
})
export class PrivacyAdminComponent implements OnInit {

  id:number
  title:string
  description:string
  options: Options[]
  withOption: boolean
  optionName:string


  constructor(public service:PrivacyAdminService, public http:HttpClient) {
    this.service.fetchContract();
  }

  ngOnInit() {
  }

  onSaveContract(){
    this.service.saveContract(this.id, this.title, this.description, this.options, this.withOption);
  }

  onDeleteContract(c:Contract){
    this.service.deleteContract(c);
  }

  onSubmit(){

  }
}
