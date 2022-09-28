import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { myDossier } from '../model/dossierMedical.model';
import { DossierMedicalService } from '../services/dossier-medical.service';

@Component({
  selector: 'app-dossier-medical-list',
  templateUrl: './dossier-medical-list.component.html',
  styleUrls: ['./dossier-medical-list.component.css']
})
export class DossierMedicalListComponent implements OnInit {
  dossierMed!: myDossier[];
  saveDossier : any = {
    id : '',
    dateCreation : '',
    etat : '',
    codeAccess : '',
    patients : ''
  
  }
  
  myCondition = false;

  constructor(private dossierMedService : DossierMedicalService,private router : Router) { }

  ngOnInit(): void {
    this.getAllDossierMed();
  }

  //----------------Methode GetAll-------------------

  public  getAllDossierMed(): void{
    this.dossierMedService.getDossierMedical().subscribe(
      (response : myDossier[])=>{
        this.dossierMed = response;
      },
      (error : HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  // -----------------Methode delete -------------------

  handleDeleteDossier(id : number) {
    let conf = confirm("Are you sure ?");
    if(conf == false) return;
    this.dossierMedService.deleteDossierMedical(id)
    .subscribe(() => {
      this.dossierMed = this.dossierMed.filter(d => d.id != id)

      })
   }
   // ---------------Methode post-------------------

   handleAddDossier(){
    
      this.dossierMedService.addDossierMedical(this.saveDossier)
      .subscribe((d) => {
        this.dossierMed = [d, ...this.dossierMed]
        this.vidInput();
   })
   }
   //---------------Methode update------------------

   handleUpdateBtn(d: any){ 
    this.saveDossier = d;
    this.myCondition = true;
   }

   UpdateDossier(){
    this.dossierMedService.updateDossierMedical(this.saveDossier)
    .subscribe(dossier =>{
      this.vidInput();
      this.myCondition = false;
    })
   }

   // Pour vider les inputs
   
   vidInput(){
    this.saveDossier = {
      id : '',
      dateCreation : '',
      etat : '',
      codeAccess : '',
      patients : ''
    }
   }

}
