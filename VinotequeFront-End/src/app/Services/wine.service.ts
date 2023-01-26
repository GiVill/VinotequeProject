import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Wine } from '../Model/Wine';

@Injectable({
  providedIn: 'root'
})
export class WineService {
  private url : string = "http://localhost:8080";

  wines !: Wine[];

  constructor(private http: HttpClient) { }

  getWines(): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/Wine",{})
    return wines;
  }

  geRedtWines(): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/redWine",{})
    return wines;
  }

  getWhiteWines(): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/whiteWine",{})
    return wines;
  }

  getRoseWines(): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/roseWine",{})
    return wines;
  }

}
