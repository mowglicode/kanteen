import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {any} from "../../../../node_modules/codelyzer/util/function";



export type Information = {

  id:number

  description:string

  expiry:string

  hasExpiration:boolean

}

@Injectable({

  providedIn: 'root'

})

export class AdminHomeService {



  informations: Information[] = [];

  notExpiredInformations: Information[] = [];

  information: Information;







  constructor(public http: HttpClient) {

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





  treatInformations() {

    this.informations.forEach(info => {

      if (!this.hasExpired(info.expiry)){

        this.notExpiredInformations.push(info);

      }

    })

  }



  delete(id) {

    let infoToDelete: Information;
    this.http.delete(this.informationUrlToDelete + id)
      .toPromise()
      .then( ()=> this.notExpiredInformations = this.notExpiredInformations.filter(i=>i.id !== id));


  }



  addInformation(i) {

    // i.expiry

    this.http.post<Information>(this.informationUrl, i)
      .toPromise()
      .then((result:Information) => {

        this.informations.push(result);
        this.notExpiredInformations.push(result);

      });

  }

}

