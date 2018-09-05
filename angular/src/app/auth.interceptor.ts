import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor,HttpHandler, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import {LoginService} from "./login.service";
@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {
  constructor(private injector : Injector,private authService : LoginService) { }
  intercept (request :  HttpRequest<any>, next : HttpHandler) : Observable <HttpEvent<any>>{

    if (this.authService.token != null){
      console.log ("injection Bearer "+this.authService.token);
      request = request.clone({
        headers: request.headers.set('Authorization', 'Bearer '+ this.authService.token)
      });
    }
    return next.handle(request)
      .pipe(catchError(error => {
          if (error.status == '401'){
            //deal with 401 response
            this.authService.logout();
            //this.router.navigate(['/login']);
          }
          return throwError(error);
        }
      ));
  }
}
