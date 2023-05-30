import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './authentication/auth.interceptor';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { EsamiPatientComponent } from './components/ForPatient/esami-patient/esami-patient.component';
import { VisitePatientComponent } from './components/ForPatient/visite-patient/visite-patient.component';
import { DatiPatientComponent } from './components/ForPatient/dati-patient/dati-patient.component';
import { AllVisiteComponent } from './components/ForOperator/all-visite/all-visite.component';
import { AllEsamiComponent } from './components/ForOperator/all-esami/all-esami.component';
import { AllPazientiComponent } from './components/ForOperator/all-pazienti/all-pazienti.component';
import { AllMediciComponent } from './components/ForOperator/all-medici/all-medici.component';
import { AllRepartiComponent } from './components/ForOperator/all-reparti/all-reparti.component';
import { NewPazienteComponent } from './components/ForOperator/new-paziente/new-paziente.component';
import { NewMedicoComponent } from './components/ForOperator/new-medico/new-medico.component';
import { NewAssociateMedicoToRepartoComponent } from './components/ForOperator/new-associate-medico-to-reparto/new-associate-medico-to-reparto.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddPazienteDialogComponent } from './components/ForOperator/add-paziente-dialog/add-paziente-dialog.component';
import { ModificaPazienteDialogComponent } from './components/ForOperator/modifica-paziente-dialog/modifica-paziente-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { AssociateMedicoRepartoComponent } from './components/ForOperator/associate-medico-reparto/associate-medico-reparto.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    EsamiPatientComponent,
    VisitePatientComponent,
    DatiPatientComponent,
    AllVisiteComponent,
    AllEsamiComponent,
    AllPazientiComponent,
    AllMediciComponent,
    AllRepartiComponent,
    NewPazienteComponent,
    NewMedicoComponent,
    NewAssociateMedicoToRepartoComponent,
    AddPazienteDialogComponent,
    ModificaPazienteDialogComponent,
    AssociateMedicoRepartoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
