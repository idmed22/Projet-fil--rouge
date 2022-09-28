import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { login } from '../model/login.model';
import { AppUser } from '../model/users.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  users : login[]=[];
  authenUser!: login;
  
  constructor() {
  this.users.push({id : 1, username : "user1", password : "1234", roles : ["USER"]});
  this.users.push({id : 2, username : "user2", password : "1234", roles : ["USER"]});
  this.users.push({id : 3, username : "admin", password : "1234", roles : ["USER","ADMIN"]});

   }


   public login(username : string, password : string) : Observable<login>{
    let login = this.users.find(u => u.username == username);
    if (!login) return throwError(()=> new Error("User not found"));
    if (login.password!= password){
      return throwError(() => new Error("Bad credentials"));
    } 
    return of(login);
  }

  public authUser(logins : login) : Observable<boolean>{
    this.authenUser = logins;
    localStorage.setItem("authUsers", JSON.stringify({username : logins.username, roles : logins.roles, jwt :"JWT_TOKEN"}));
    return of(true);
    }

    public hasRole(role : string) : boolean{
      return this.authenUser!.roles.includes(role);
    }
  
    public isAuth(){
      return this.authenUser!=undefined;
    }
  
    public logout() : Observable< boolean>{
      this.authenUser!= undefined;
      localStorage.removeItem("authUsers");
      return of(true);
    }
}
