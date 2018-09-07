import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  isAdmin: boolean = undefined;
  isLogged: boolean = false;
  mailLogged : string = undefined;

  constructor(private http: HttpClient) {
  }

  checkLoginStatus(email: string) {
    this.http.get("http://localhost:8585/api/accounts/isAdmin/" + email)
      .subscribe((t: boolean) => {
        this.isAdmin = t;
        if (this.isAdmin !== undefined) {
          this.isLogged = true;
          this.mailLogged = email;
        }
      });

  }

}
