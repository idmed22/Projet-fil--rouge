import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { RendezVousListComponent } from './rendez-vous-list/rendez-vous-list.component';
import { FormsModule } from '@angular/forms';
import { FactureListComponent } from './facture-list/facture-list.component';
import { AnalyseListComponent } from './analyse-list/analyse-list.component';
import { DossierMedicalListComponent } from './dossier-medical-list/dossier-medical-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    AdminDashboardComponent,
    UsersComponent,
    RendezVousListComponent,
    FactureListComponent,
    AnalyseListComponent,
    DossierMedicalListComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
