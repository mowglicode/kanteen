import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Menu} from "./menus/menus.service";

export interface Contract {
  title:string,
  description:string,
  options: Options[]
  withOption: boolean;
}

export interface Options {
  optionName:string
}




@Injectable({
  providedIn: 'root'
})
export class PrivacyService {

  privacy: Contract[] = [];


  constructor(public http: HttpClient) {
  }

  fetchContract() {
    this.http.get<any[]>('http://localhost:8585/api/admin/privacy/contracts')
      .subscribe((r: any[]) => {
        this.privacy = r.map(contract => mapAnyToContract(contract));
        console.log('contracts', this.privacy);
      });
  }
}

  function mapAnyToContract(contract: any): Contract {
    return {
      title: contract.title,
      description: contract.description,
      options: contract.options,
      withOption: contract.withOption
    }
  }








