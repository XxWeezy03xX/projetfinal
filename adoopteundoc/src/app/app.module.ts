import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PraticienComponent } from './praticien/praticien.component';
import {PatientComponent} from './patient/patient.component';

@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent,
    PatientComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
