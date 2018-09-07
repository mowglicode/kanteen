import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Contract {
  id:number
  title:string
  description:string
  options: Options[]
  withOption: boolean
}

export interface Options {
  optionName:string
}

@Injectable({
  providedIn: 'root'
})
export class PrivacyAdminService {

  privacy: Contract[] = [];
  privacy2: Contract

  constructor(public http: HttpClient) { }

  fetchContract() {
    this.http.get<any[]>('http://localhost:8585/api/admin/privacy/contracts')
      .subscribe((r: any[]) => {
        this.privacy = r.map(contract => mapAnyToContract(contract));
        console.log('contracts', this.privacy);
      });
  }


  saveContract(id:number, title: string, description: string, options:Options[], withOption: boolean) {
    let body: Contract = {
      id:id,
      title: title,
      description: description,
      options: options,
      withOption: withOption
    }


    this.http.post('http://localhost:8585/api/admin/privacy/contracts', body)
      .subscribe((r: any) => {
        this.privacy.push(r)
        console.log(this.privacy);
      });

  }

  deleteContract(c){
    let id = c.id
    this.http.delete('http://localhost:8585/api/admin/privacy/contracts/'+id)
      .toPromise()
      .then( ()=> this.privacy = this.privacy.filter(c=>c.id !==id));
  }

}



function mapAnyToContract(contract: any): Contract {
  return {
    id: contract.id,
    title: contract.title,
    description: contract.description,
    options: contract.options,
    withOption: contract.withOption
  }
}
