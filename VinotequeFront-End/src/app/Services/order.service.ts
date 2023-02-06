import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../Model/Order';
import { Promotion } from '../Model/Promotion';
import { User } from '../Model/User';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private url : string = "http://localhost:8080";

  public logged : Boolean = false;

  public currentUser !: User | null ;

  public favourites !: Number[]

  constructor(private http: HttpClient) { }

  postOrder(order : Order): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/newOrdine",order);
  }

  getOrders(userId : BigInt): Observable<Order[]>{
    var wine : Observable<Order[]> = this.http.post<Order[]>(this.url + "/ordineUtente",userId)
    return wine;
  }

  addPromoCode(promo : Promotion): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/newPromo",promo);
  }

  getPromoCode(promo : string): Observable<Promotion>{
    return this.http.post<Promotion>(this.url + "/findPromoReturn",promo);
  }

  getRandomPromoCode(): Observable<Promotion>{
    return this.http.get<Promotion>(this.url + "/promoRandom",{});
  }
}
