import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { DatiPatientComponent } from './components/ForPatient/dati-patient/dati-patient.component';
import { EsamiPatientComponent } from './components/ForPatient/esami-patient/esami-patient.component';
import { VisitePatientComponent } from './components/ForPatient/visite-patient/visite-patient.component';

const routes: Routes = [
  {path:'Home', component: HomeComponent },
  {path:'Login', component:LoginComponent},
  {path:'Register', component:RegisterComponent},
  {path:'Dati-Paziente', component:DatiPatientComponent},
  {path:'Esami-Paziente', component:EsamiPatientComponent},
  {path:'Visite-Paziente', component:VisitePatientComponent},
  {path: '', redirectTo: 'Home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
