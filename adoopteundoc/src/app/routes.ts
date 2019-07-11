import {Routes} from '@angular/router';
import {InfoPatientComponent} from './info-patient/info-patient.component';
import {CanActivate} from '@angular/router';
import {PraticienComponent} from './praticien/praticien.component';

export const routes: Routes = [
  { path: 'patient/:id', component: InfoPatientComponent},
  { path: 'praticiens', component: PraticienComponent}
]
