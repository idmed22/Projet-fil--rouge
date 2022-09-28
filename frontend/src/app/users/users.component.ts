import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppUser } from '../model/users.model';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  Users!: AppUser[];  
  saveUser : any = {
    id : '',
    nom : '',
    prenom : '',
    email : '',
    adresse : '',
    dateNaissance : '',
    tel : '' ,
    ville : '',
    gender : '',
    username : ''
  
  }
  
  myCondition = false;

  
  constructor(private  usersService : UsersService ,private router : Router) { }

  ngOnInit(): void {
  this.getUsers();
  }

//----------------Methode GetAll-------------------

  public  getUsers(): void{
    this.usersService.getUsers().subscribe(
      (response : AppUser[])=>{
        this.Users = response;
      },
      (error : HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

// -----------------Methode delete -------------------

  handleDeleteUser(id : number) {
    let conf = confirm("Are you sure ?");
    if(conf == false) return;
    this.usersService.deleteUser(id)
    .subscribe(() => {
      this.Users = this.Users.filter(u => u.id != id)

      })
   }
   // ---------------Methode post-------------------

   handleAddUser(){
    
      this.usersService.addUsers(this.saveUser)
      .subscribe((u) => {
        this.Users = [u, ...this.Users]
        this.vidInput();
   })
   }
   //---------------Methode update------------------

   handleUpdateUser(u: any){ // change name of this into btnUpdate
    this.saveUser = u;
    this.myCondition = true;
   }

   UpdateUser(){
    this.usersService.updateUsers(this.saveUser)
    .subscribe(user =>{
      this.vidInput();
      this.myCondition = false;
    })
   }

   // Pour vider les inputs
   
   vidInput(){
    this.saveUser = {
      id : '',
      nom : '',
      prenom : '',
      email : '',
      adresse : '',
      dateNaissance : '',
      tel : '' ,
      ville : '',
      gender : '',
      username : ''

    }
   }
    
   





 
  


 
  
}
