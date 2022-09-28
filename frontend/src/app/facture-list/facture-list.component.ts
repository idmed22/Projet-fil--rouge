import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { myFacture } from '../model/facture.model';
import { FactureService } from '../services/facture.service';

@Component({
  selector: 'app-facture-list',
  templateUrl: './facture-list.component.html',
  styleUrls: ['./facture-list.component.css']
})
export class FactureListComponent implements OnInit {
  factures!: myFacture[];
  saveFacture : any = {
    id : '',
    montant : '',
    payer : '',
    factureDate :'',
    patients : '',
  
  }
  
  myCondition = false;
  constructor(private  factureService :FactureService ,private router : Router) { }

  ngOnInit(): void {
 this.getAllFactures();

  }

  //----------------Methode GetAll-------------------

  public  getAllFactures(): void{
    this.factureService.getAllFactures().subscribe(
      (response : myFacture[])=>{
        this.factures = response;
      },
      (error : HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  // -----------------Methode delete -------------------

  handleDeleteFacture(id : number) {
    let conf = confirm("Are you sure ?");
    if(conf == false) return;
    this.factureService.deleteFacture(id)
    .subscribe(() => {
      this.factures = this.factures.filter(f => f.id != id)

      })
   }
   // ---------------Methode post-------------------

   handleAddUser(){
    
      this.factureService.addFacture(this.saveFacture)
      .subscribe((f) => {
        this.factures = [f, ...this.factures]
        this.vidInput();
   })
   }
   //---------------Methode update------------------

   handleUpdateBtn(f: any){ 
    this.saveFacture = f;
    this.myCondition = true;
   }

   UpdateFacture(){
    this.factureService.updateRendezVous(this.saveFacture)
    .subscribe(facture =>{
      this.vidInput();
      this.myCondition = false;
    })
   }

   // Pour vider les inputs
   
   vidInput(){
    this.saveFacture = {
      id : '',
      montant : '',
      payer : '',
      factureDate :'',
      patients : '',

    }
   }
    
   

}
