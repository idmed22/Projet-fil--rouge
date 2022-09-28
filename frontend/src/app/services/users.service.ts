import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppUser } from '../model/users.model';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

   API_URL = "http://localhost:8081/api/users";
  

  constructor(private httpclient : HttpClient) { }
 
 // getAll 
 getUsers() : Observable<AppUser[]>{
  return this.httpclient.get<AppUser[]>(`${this.API_URL}`);
}

  // getById
 getUserById(id : number) : Observable<AppUser>{
  return this.httpclient.get<AppUser>(`${this.API_URL}/${id}`)
}

 // post
 addUsers(users : AppUser){
  return this.httpclient.post<AppUser>(`${this.API_URL}`,users);
}
  // put
 updateUsers(users : AppUser){
  return this.httpclient.put(`${this.API_URL}/${users.id}`,users);
}

 // delete 
 deleteUser(id : number) : Observable<any>{
  return this.httpclient.delete(`${this.API_URL}/${id}`);
}





  
 
  
}
