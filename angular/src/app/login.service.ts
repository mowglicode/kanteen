import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  isAdmin: boolean = false;
  isLogged: boolean = true;

  constructor(private http: HttpClient) {
  }

  checkLoginStatus(email: string) {
    this.http.get("http://localhost:8585/api/accounts/isAdmin/" + email)
      .subscribe((t: boolean) => {
        this.isAdmin = t;
        if (this.isAdmin !== undefined) {
          this.isLogged = true;
        }
      });

  }

}
