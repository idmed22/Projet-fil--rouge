import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { myRendezVous} from '../model/rendezVous.model';

@Injectable({
  providedIn: 'root'
})
export class RendezVousService {
  API_URL = "http://localhost:8081/api/RendezVous";
  
  constructor(private httpclient : HttpClient) { }

  // getAll 
 getAllRendezVous() : Observable<myRendezVous[]>{
  return this.httpclient.get<myRendezVous[]>(`${this.API_URL}`);
}

 // getById
 getRendezVousById(id : number) : Observable<myRendezVous>{
  return this.httpclient.get<myRendezVous>(`${this.API_URL}/${id}`)
}

 // post
 addRendezVous(rendezVous : myRendezVous){
  return this.httpclient.post<myRendezVous>(`${this.API_URL}`,rendezVous);
}
  // put
 updateRendezVous(rendezVous : myRendezVous){
  return this.httpclient.put(`${this.API_URL}/${rendezVous.id}`,rendezVous);
}

 // delete 
 deleteRendezVous(id : number) : Observable<any>{
  return this.httpclient.delete(`${this.API_URL}/${id}`);
}
}
