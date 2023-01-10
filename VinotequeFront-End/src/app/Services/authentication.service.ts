import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url : string = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  register(body : {}): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/newUser", {body});
  }

  checkLogin(jsessionid: string): Observable<Boolean>{
    return this.http.get<Boolean>(this.url + "/checkAuth", {params: {jsessionid: jsessionid}});
  }
}
