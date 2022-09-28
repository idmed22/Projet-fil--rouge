import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { myRendezVous } from '../model/rendezVous.model';
import { RendezVousService } from '../services/rendez-vous.service';


@Component({
  selector: 'app-rendez-vous-list',
  templateUrl: './rendez-vous-list.component.html',
  styleUrls: ['./rendez-vous-list.component.css']
})
export class RendezVousListComponent implements OnInit {
  rendezVous!: myRendezVous[];  
  saveRDV : any = {
    id : '',
    rendezVousDate : '',
    valider : '',
    patients : '',
  }
  
  myCondition = false;

  constructor(private  RDVService : RendezVousService ,private router : Router) { }

  ngOnInit(): void {
    this.getAllRendezVous();
  }

  //----------------Methode GetAll-------------------

  public  getAllRendezVous(): void{
    this.RDVService.getAllRendezVous().subscribe(
      (response : myRendezVous[])=>{
        this.rendezVous = response;
      },
      (error : HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  // -----------------Methode delete -------------------

  handleDeleteRDV(id : number) {
    let conf = confirm("Are you sure ?");
    if(conf == false) return;
    this.RDVService.deleteRendezVous(id)
    .subscribe(() => {
      this.rendezVous = this.rendezVous.filter(r => r.id != id)

      })
   }

   // ---------------Methode post-------------------

   handleAddRDV(){
    this.RDVService.addRendezVous(this.saveRDV)      
    .subscribe((r) => {
      this.rendezVous = [r, ...this.rendezVous]
      this.vidInput();
 })
 }
 //---------------Methode update------------------

 handleUpdateBtn(r: any){ 
  this.saveRDV = r;
  this.myCondition = true;
 }

 UpdateRDV(){
  this.RDVService.updateRendezVous(this.saveRDV)
  .subscribe(RDV =>{
    this.vidInput();
    this.myCondition = false;
  })
 }

 // Pour vider les inputs
 
 vidInput(){
  this.saveRDV = {
    id : '',
    rendezVousDate : '',
    valider : '',
    patients : ''

  }
 }
  

}
