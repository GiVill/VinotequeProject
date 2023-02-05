import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../Model/Cart';
import { User } from '../Model/User';
import { WineService } from './wine.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url : string = "http://localhost:8080";

  public logged : Boolean = false;

  public currentUser !: User | null ;

  public favourites !: Number[]

  constructor(private http: HttpClient,
              private wineService : WineService) { }

  isLogged(){
    return this.logged;
  }

  isAdmin(){
    if(this.currentUser == null){
      return false;
    } else {
      return (this.currentUser.ruolo == "ADMIN");
    }
  }

  isSommelier(){
    if(this.currentUser == null){
      return false;
    } else {
      return(this.currentUser.ruolo =="SOMMELIER");
    }
  }

  isInFavorites(id : Number):boolean{
    let isIn = false
    if(this.isLogged()){
     if(this.favourites != undefined){
      this.favourites.forEach(element => {
        if(element == id){
          isIn = true
        }
      });
     }
    }
    return isIn
  }

  register(newUser : User): Observable<Boolean>{
    console.log(newUser); //EROE!!!!!!!!!!
    return this.http.post<Boolean>(this.url + "/addUser",newUser);
  }

  checkLogin(jsessionid: string): Observable<User>{
    return this.http.get<User>(this.url + "/checkAuth", {params: {jsessionid: jsessionid}});
  }

  logout(jsessionid: string): Observable<Boolean>{
    return this.http.get<Boolean>(this.url + "/logout",{params:{jsessionid:jsessionid}});
  }

  addCart(cart : Cart): Observable<Boolean>{
    console.log(cart); //EROE!!!!!!!!!!
    return this.http.post<Boolean>(this.url + "/addCart",cart);
  }

  updateUser(user : User): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/aggiornaUtente",user);
  }
}
