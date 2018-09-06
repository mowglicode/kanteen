import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})
export class DataComponent implements OnInit {

  disabled: boolean = false;

  constructor(public service:DataService) { }

  ngOnInit() {
  }

  createDatabase(){
    this.service.createDatabase();
    this.disablingButtonCreateDB()
  }

  disablingButtonCreateDB(){
    this.disabled = true;
  }

}
