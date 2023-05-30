import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { DatiPatientComponent } from './components/ForPatient/dati-patient/dati-patient.component';
import { EsamiPatientComponent } from './components/ForPatient/esami-patient/esami-patient.component';
import { VisitePatientComponent } from './components/ForPatient/visite-patient/visite-patient.component';
import { AllEsamiComponent } from './components/ForOperator/all-esami/all-esami.component';
import { AllMediciComponent } from './components/ForOperator/all-medici/all-medici.component';
import { AllPazientiComponent } from './components/ForOperator/all-pazienti/all-pazienti.component';
import { AllRepartiComponent } from './components/ForOperator/all-reparti/all-reparti.component';
import { AllVisiteComponent } from './components/ForOperator/all-visite/all-visite.component';

const routes: Routes = [
  {path:'Home', component: HomeComponent },
  {path:'Login', component:LoginComponent},
  {path:'Register', component:RegisterComponent},
  {path:'Dati-Paziente', component:DatiPatientComponent},
  {path:'Esami-Paziente', component:EsamiPatientComponent},
  {path:'Visite-Paziente', component:VisitePatientComponent},
  {path:'All-Esami', component: AllEsamiComponent},
  {path:'All-Medici', component: AllMediciComponent},
  {path:'All-Pazienti', component: AllPazientiComponent},
  {path:'All-Reparti', component: AllRepartiComponent},
  {path:'All-Visite', component: AllVisiteComponent},
  {path: '', redirectTo: 'Home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
