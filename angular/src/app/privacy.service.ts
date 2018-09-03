import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface Contract {
  title:string,
  description:string,
}

@Injectable({
  providedIn: 'root'
})
export class PrivacyService {

  privacy: Contract[] = [];

  constructor(public http:HttpClient) { }

  fetchContract(){
    this.http.get<any[]>('http://localhost:8080/api/admin/privacy/contracts')
      .subscribe((r: any[]) => {
        this.privacy = r.map(contract => mapAnyToContract(contract));
        console.log(this.privacy);
      });
  }}

  function mapAnyToContract(contract:any):Contract{
    return{
      title:contract.title,
      description:contract.description
  }

}
