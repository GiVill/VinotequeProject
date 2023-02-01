import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../Model/Review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private url : string = "http://localhost:8080";

  review !: Review[]

  constructor(private http: HttpClient) { }

  getReviews(idVino : BigInt): Observable<Review[]>{
    var reviews : Observable<Review[]> = this.http.post<Review []>(this.url + "/Review",idVino,{})
    return reviews;
  }

  postReview(recensione : Review): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/saveReview",recensione);
  }
}
