import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PraticienComponent } from './praticien/praticien.component';

import {PatientComponent} from './patient/patient.component';

import {HttpClientModule} from '@angular/common/http';
import {PatientService} from './service/patient.service';
import {PraticienService} from './service/praticien.service';

import { PraticienDetailComponent } from './praticien-detail/praticien-detail.component';

import { PatientDetailComponent } from './patient-detail/patient-detail.component';
import {FormsModule} from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { InfoPatientComponent } from './info-patient/info-patient.component';



@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent,
    PatientComponent,
    PraticienDetailComponent,
    PatientDetailComponent,
    HeaderComponent,
    InfoPatientComponent

  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule
  ],
  providers: [PatientService, PraticienService],
  bootstrap: [AppComponent]
})
export class AppModule { }
