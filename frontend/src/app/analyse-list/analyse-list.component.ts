import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { myAnalyse } from '../model/analyse.model';
import { AnalyseService } from '../services/analyse.service';

@Component({
  selector: 'app-analyse-list',
  templateUrl: './analyse-list.component.html',
  styleUrls: ['./analyse-list.component.css']
})
export class AnalyseListComponent implements OnInit {

  analyses!: myAnalyse[];
  saveAnalyse : any = {
    id : '',
    analyseType : '',
    analyseTypePartie :'',
    datePrelevement : '',
    description : '',
    nomPreleveur : '',
    sangTypes : ''
  }

  myCondition = false;

  constructor(private analyseService : AnalyseService ,private router : Router) { }

  ngOnInit(): void {
    this.getAllAnalyses();
  }

  //----------------Methode GetAll-------------------

  public  getAllAnalyses(): void{
    this.analyseService.getAnalyse().subscribe(
      (response : myAnalyse[])=>{
        this.analyses = response;
      },
      (error : HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  // -----------------Methode delete -------------------

  handleDeleteAnalyse(id : number) {
    let conf = confirm("Are you sure ?");
    if(conf == false) return;
    this.analyseService.deleteAnalyse(id)
    .subscribe(() => {
      this.analyses = this.analyses.filter(a => a.id != id)

      })
   }

    // ---------------Methode post-------------------

    handleAddanalyse(){
    
      this.analyseService.addAnalyse(this.saveAnalyse)
      .subscribe((a) => {
        this.analyses = [a, ...this.analyses]
        this.vidInput();
   })
   }

   //---------------Methode update------------------

   handleUpdateBtn(a: any){ 
    this.analyses = a;
    this.myCondition = true;
   }

   UpdateAnalyse(){
    this.analyseService.updateAnalyse(this.saveAnalyse)
    .subscribe(analyse =>{
      this.vidInput();
      this.myCondition = false;
    })
   }


   // Pour vider les inputs
   
   vidInput(){
    this.saveAnalyse = {
      id : '',
      analyseType : '',
      analyseTypePartie :'',
      datePrelevement : '',
      description : '',
      nomPreleveur : '',
      sangTypes : ''

    }
   }

}
