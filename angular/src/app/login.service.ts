import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  token: string;

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);
    params.append('grant_type', 'password');
    params.append('client_id', 'crm');
    const headers = new HttpHeaders()
      .set('Content-type', 'application/x-www-form-urlencoded; charset=utf-8')
      .set('Authorization', 'Basic ' + btoa('crm:crm-secret'));
    return this.http.post<any>('http://10.31.1.35:8080/oauth/token', params.toString(), {responseType: 'json', headers})
      .pipe(map(token => {
        if (token) {
          this.token = token.access_token;
        }
        return token;
      }));
  }

  logout() {
    this.token = null;
  }
}
