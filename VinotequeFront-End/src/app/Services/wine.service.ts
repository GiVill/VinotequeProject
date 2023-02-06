import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favorite } from '../Model/Favorite';
import { Wine } from '../Model/Wine';

@Injectable({
  providedIn: 'root'
})
export class WineService {

  private url : string = "http://localhost:8080";

  wines !: Wine[];

  constructor(private http: HttpClient) { }

  getWineById(id:BigInt): Observable<Wine>{
    var wine : Observable<Wine> = this.http.post<Wine>(this.url + "/WineById",id)
    return wine;
  }

  getRandomWine(): Observable<Wine[]> {
    var wines : Observable<Wine[]> = this.http.get<Wine[]>(this.url + "/randomWine",{})
    return wines;
  }

  getWines(): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/Wine",{})
    return wines;
  }

  getWinesByName(name : string): Observable<Wine>{
    var wine : Observable<Wine> = this.http.get<Wine>(this.url + "/WineByName",{params: {name}})
    return wine;
  }

  getRedWines(): Observable<Wine[]>{
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

  getFavorites(id:BigInt): Observable<Wine[]>{
    var favorites : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/favorites",id,{})
    return favorites;
  }

  getFavoritesID(id:BigInt): Observable<Number[]>{
    var favorites : Observable<Number[]> = this.http.post<Number[]>(this.url + "/favoritesID",id,{})
    return favorites;
  }

  addFavorite(favorite : Favorite): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/addFavorite",favorite);
  }

  delFavorite(favorite : Favorite): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/delFavorite",favorite);
  }

  getPriceWines(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/price",max,{})
    return wines;
  }

  getGradation(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/GradazioneWine",max,{})
    return wines;
  }

  getPriceWinesRed(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/priceRosso",max,{})
    return wines;
  }

  getGradationRed(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/GradazioneWineRosso",max,{})
    return wines;
  }

  getPriceWinesWhite(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/priceBianco",max,{})
    return wines;
  }

  getGradationWhite(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/GradazioneWineBianco",max,{})
    return wines;
  }

  getPriceWinesRose(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/priceRosè",max,{})
    return wines;
  }

  getGradationRose(max:number): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/GradazioneWineRosè",max,{})
    return wines;
  }

  addWine(wine:Wine): Observable<Boolean>{
    return this.http.post<Boolean>(this.url + "/newVino",wine,{});
  }

}
