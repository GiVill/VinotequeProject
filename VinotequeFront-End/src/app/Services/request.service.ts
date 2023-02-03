import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestSommelier } from '../Model/RequestSommelier';

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

  sendRequest(richiesta: RequestSommelier): Observable<Boolean>{
    var requestsSommelier : Observable<Boolean> = this.http.post<Boolean>(this.url + "/newRichiesta",richiesta)
    return requestsSommelier;
  }

  accept(richiesta: RequestSommelier): Observable<Boolean>{
    var requestsSommelier : Observable<Boolean> = this.http.post<Boolean>(this.url + "/Accetta", richiesta)
    return requestsSommelier;
  }

  refuse(richiesta: RequestSommelier): Observable<Boolean>{
    var requestsSommelier : Observable<Boolean> = this.http.post<Boolean>(this.url + "/Rifiuta", richiesta)
    return requestsSommelier;
  }

}
