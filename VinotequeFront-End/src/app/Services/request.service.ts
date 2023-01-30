import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestSommelier } from '../Model/ReuestSommelier';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  private url : string = "http://localhost:8080";

  richieste !: RequestSommelier[]

  constructor(private http: HttpClient) { }

  getRequests(): Observable<RequestSommelier[]>{
    var requestsSommelier : Observable<RequestSommelier[]> = this.http.post<RequestSommelier []>(this.url + "/request",{})
    return requestsSommelier;
  }

}
