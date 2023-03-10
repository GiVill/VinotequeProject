import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url : string = "http://localhost:8080";

  public isLogged : Boolean = false;

  public currentUser !: User;

  constructor(private http: HttpClient) { }

  register(newUser : User): Observable<Boolean>{
    console.log(newUser); //EROE!!!!!!!!!!
    return this.http.post<Boolean>(this.url + "/addUser",newUser);
  }

  checkLogin(jsessionid: string): Observable<User>{
    return this.http.get<User>(this.url + "/checkAuth", {params: {jsessionid: jsessionid}});
  }
}
