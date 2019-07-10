import {Routes} from '@angular/router';
import {InfoPatientComponent} from './info-patient/info-patient.component';

export const routes: Routes = [
  { path: 'patient/:id', component: InfoPatientComponent}
]
