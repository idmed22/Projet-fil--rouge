import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { myAnalyse } from '../model/analyse.model';

@Injectable({
  providedIn: 'root'
})
export class AnalyseService {
  API_URL = "http://localhost:8081/api/analyse";

  constructor(private httpclient : HttpClient) { }

  // getAll 
 getAnalyse() : Observable<myAnalyse[]>{
  return this.httpclient.get<myAnalyse[]>(`${this.API_URL}`);

}

  // getById
  getAnalyseById(id : number) : Observable<myAnalyse>{
    return this.httpclient.get<myAnalyse>(`${this.API_URL}/${id}`)
  }

  // post
 addAnalyse(analyses : myAnalyse){
  return this.httpclient.post<myAnalyse>(`${this.API_URL}`,analyses);
}
  // put
 updateAnalyse(analyses : myAnalyse){
  return this.httpclient.put(`${this.API_URL}/${analyses.id}`,analyses);
}

 // delete 
 deleteAnalyse(id : number) : Observable<any>{
  return this.httpclient.delete(`${this.API_URL}/${id}`);
}
}
