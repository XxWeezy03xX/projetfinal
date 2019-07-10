import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PraticienComponent } from './praticien/praticien.component';
import {HttpClientModule} from "@angular/common/http";
import {PatientService} from "./service/patient.service";
import {PraticienService} from "./service/praticien.service";

@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent
  ],
  imports: [
    BrowserModule, HttpClientModule
  ],
  providers: [PatientService, PraticienService],
  bootstrap: [AppComponent]
})
export class AppModule { }
