import { Injectable } from '@angular/core';
import {HttpClient} from "../../../node_modules/@angular/common/http";
import {Contract} from "../privacy.service";

export interface Contract {
  title:string,
  description:string,
  options: Options[]
  withOption: boolean;
}
export interface ContractLight {
  title:string,
  description:string

}

export interface Options {
  optionName:string
}

@Injectable({
  providedIn: 'root'
})
export class PrivacyAdminService {
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

  saveContract(title:string, description:string){
    let body:ContractLight={
      title:title,
      description:description
    }
    this.http.post('http://localhost:8585/api/admin/privacy/contracts', body)
      .subscribe((r:any) => {
        this.privacy.push(r)
        console.log(this.privacy);
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
