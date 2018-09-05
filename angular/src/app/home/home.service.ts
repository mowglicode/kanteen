import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export type Information = {
  id:number
  description:string
  expiry:string
  hasExpiration:boolean
}
@Injectable({
  providedIn: 'root'
})
export class HomeService {

  informations: Information[] = [];
  notExpiredInformations: Information[] = [];
  information: Information;
  show = false;
  idDiv = -1;


  constructor(public http: HttpClient) {

    // console.log('1978-11-01', this.hasExpired('1978-11-01'));
    // console.log('2018-08-06', this.hasExpired('2018-08-06'));
    // console.log('2018-09-04', this.hasExpired('2018-09-04'));
    // console.log('2018-08-05', this.hasExpired('2018-08-05'));
    // console.log('2008-09-04', this.hasExpired('2008-09-04'));
    // console.log('2018-09-09', this.hasExpired('2018-09-09'));
    // console.log('2018-09-04', this.hasExpired('2018-09-04'));
    // console.log('2019-09-05', this.hasExpired('2019-09-05'));
    // console.log('2018-07-04', this.hasExpired('2018-07-04'));
    // console.log('2018-07-05', this.hasExpired('2018-07-05'));
    // console.log('2018-08-04', this.hasExpired('2018-08-04'));
    // console.log('2018-10-04', this.hasExpired('2018-10-04'));
    // console.log('2018-10-10', this.hasExpired('2018-10-10'));
  }

  informationUrl = 'http://localhost:8585/api/informations';

  informationUrlToDelete = 'http://localhost:8585/api/informations/';

  getInformation() {
    return this.http.get(this.informationUrl);
  }

  hasExpired(expiry:string) {
    let expiryDate=new Date();
    expiryDate.setFullYear(parseInt(expiry.slice(0,4)));
    expiryDate.setUTCMonth(parseInt(expiry.slice(5,7)) -1 ); // Month starts at 0 !
    expiryDate.setUTCDate(parseInt(expiry.slice(8,11))); // day of the month, starts at 1

    let now = new Date();

    return expiryDate.getTime() - now.getTime() < -1;
  }

  getAllInformations() {
    this.http.get(this.informationUrl)
      .subscribe((result: any[]) => {
        this.informations = result
        this.treatInformations();
      });
  }

  showDescription(id) {
    !this.show ?  this.show = true : this.show = false;
    this.idDiv = id;
  }

  showIfExpiry() {

    // console.log(this.information.expiry - this.datePipe.transform(this.today, 'yyyyMMdd'));
  }

  treatInformations() {
    this.informations.forEach(info => {
      if (!this.hasExpired(info.expiry)){
        this.notExpiredInformations.push(info);
      }
    })
  }
}

