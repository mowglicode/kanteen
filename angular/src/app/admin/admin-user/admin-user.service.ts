import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Account} from "../../meals/meals.service";

export type Account = {
  id?: number;
  email: string;
  phone?: string;
  password?: string;
}
export type Admin = {
  id?: number;
  account: Account;
  name: string;

}

@Injectable({
  providedIn: 'root'
})
export class AdminUserService {

  constructor(public http: HttpClient) {
  }

  admins: Admin[] = [];


  postNewUser(name: string, email: string, phone: string, pass: string) {
    let newAccount: Account = {
      id:0,
      email: email,
      phone: phone,
      password: pass
    }
    let body: Admin = {
      name: name,
      account: newAccount,
    }

    this.http.post('http://localhost:8585/api/admins',body)
      .subscribe((r:any) => {
        this.admins.push(r)
      });
  }

  getAllAdmins() {
    this.http.get('http://localhost:8585/api/admins')
      .subscribe((r: any) => {
        this.admins = r
        console.log(this.admins);
      });
  }

  // deleteAdmin(idAdmin:number,idAccount:number){
  //   console.log(idAdmin+" supprimé")
  //   this.http.delete('http://localhost:8585/api/admins/'+idAdmin)
  //   this.http.delete('http://localhost:8585/api/accounts/'+idAccount)
  // }
}
