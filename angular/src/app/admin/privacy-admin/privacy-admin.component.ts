import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-privacy-admin',
  templateUrl: './privacy-admin.component.html',
  styleUrls: ['./privacy-admin.component.css']
})
export class PrivacyAdminComponent implements OnInit {

  title:string;
  description:string

  constructor() { }

  ngOnInit() {
  }

}
