import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { myDossier } from '../model/dossierMedical.model';

@Injectable({
  providedIn: 'root'
})
export class DossierMedicalService {
  API_URL = "http://localhost:8081/api/dossierMedical";

  constructor(private httpclient : HttpClient) { }

  // getAll 
 getDossierMedical() : Observable<myDossier[]>{
  return this.httpclient.get<myDossier[]>(`${this.API_URL}`);

}

  // getById
  getDossierMedicalById(id : number) : Observable<myDossier>{
    return this.httpclient.get<myDossier>(`${this.API_URL}/${id}`)
  }

  // post
 addDossierMedical(dossierM : myDossier){
  return this.httpclient.post<myDossier>(`${this.API_URL}`,dossierM);
}
  // put
 updateDossierMedical(dossierM : myDossier){
  return this.httpclient.put(`${this.API_URL}/${dossierM.id}`,dossierM);
}

 // delete 
 deleteDossierMedical(id : number) : Observable<any>{
  return this.httpclient.delete(`${this.API_URL}/${id}`);
}

}
