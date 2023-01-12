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

  register(newUser : User): Observable<Boolean>{
    console.log(newUser); //EROE!!!!!!!!!!
    return this.http.post<Boolean>(this.url + "/addUser",newUser);
  }

  checkLogin(jsessionid: string): Observable<Boolean>{
    return this.http.get<Boolean>(this.url + "/checkAuth", {params: {jsessionid: jsessionid}});
  }
}
