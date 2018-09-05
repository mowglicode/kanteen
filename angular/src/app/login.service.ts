import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  token: any;

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);
    params.append('grant_type', 'password');
    params.append('client_id', 'formation');
    const headers = new HttpHeaders()
      .set('Content-type', 'application/x-www-form-urlencoded; charset=utf-8')
      .set('Authorization', 'Basic ' + btoa('formation:31415'));
    return this.http.post<any>('http://localhost:8585/oauth/token', params.toString(), {responseType: 'json', headers})
      .pipe(map(token => {
        if (token) {
          console.log(token);
          this.token = token.access_token;
        }
        return token;
      }));
  }

  logout() {
    this.token = null;
  }
}
