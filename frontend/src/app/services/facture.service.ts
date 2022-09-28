import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { myFacture } from '../model/facture.model';

@Injectable({
  providedIn: 'root'
})
export class FactureService {
  API_URL = "http://localhost:8081/api/facture";

  constructor(private httpclient : HttpClient) { }


   // getAll 
 getAllFactures() : Observable<myFacture[]>{
  return this.httpclient.get<myFacture[]>(`${this.API_URL}`);
}

 // getById
 getFactureById(id : number) : Observable<myFacture>{
  return this.httpclient.get<myFacture>(`${this.API_URL}/${id}`)
}

 // post
 addFacture(factures : myFacture){
  return this.httpclient.post<myFacture>(`${this.API_URL}`,factures);
}
  // put
 updateRendezVous(factures : myFacture){
  return this.httpclient.put(`${this.API_URL}/${factures.id}`,factures);
}

 // delete 
 deleteFacture(id : number) : Observable<any>{
  return this.httpclient.delete(`${this.API_URL}/${id}`);
}
}
