import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from '../admin-dashboard/admin-dashboard.component';
import { AnalyseListComponent } from '../analyse-list/analyse-list.component';
import { DossierMedicalListComponent } from '../dossier-medical-list/dossier-medical-list.component';
import { FactureListComponent } from '../facture-list/facture-list.component';
import { AuthentificationGuard } from '../guards/authentification.guard';
import { LoginComponent } from '../login/login.component';
import { RendezVousListComponent } from '../rendez-vous-list/rendez-vous-list.component';
import { SignupComponent } from '../signup/signup.component';
import { UsersComponent } from '../users/users.component';


const routes: Routes = [
  {path : "login", component : LoginComponent}, 
  {path : "", component : LoginComponent},
  {path : "adminDashboard", component : AdminDashboardComponent},
  { path: 'users', component: UsersComponent, canActivate : [AuthentificationGuard]},
  { path: 'rendezVousList', component: RendezVousListComponent },
  { path: 'factureList', component: FactureListComponent },
  { path: 'analyseList', component: AnalyseListComponent},
  { path: 'dossierMedicalList', component: DossierMedicalListComponent },
  { path: 'signup', component: SignupComponent },
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }