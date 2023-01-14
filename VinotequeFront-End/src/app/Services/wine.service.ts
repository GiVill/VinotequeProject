import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Wine } from '../Wine';

@Injectable({
  providedIn: 'root'
})
export class WineService {
  private url : string = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  getWines(): Observable<Wine[]>{
    var wines : Observable<Wine[]> = this.http.post<Wine []>(this.url + "/Wine",{})
    return wines;
  }
}
