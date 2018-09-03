import { Component, OnInit } from '@angular/core';
import {PrivacyService} from "../privacy.service";

@Component({
  selector: 'app-privacy',
  templateUrl: './privacy.component.html',
  styleUrls: ['./privacy.component.css']
})
export class PrivacyComponent implements OnInit {

  constructor(public service:PrivacyService) {
    this.service.fetchContract();
  }

  ngOnInit() {
  }

}
