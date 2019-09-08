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
import { FooterComponent } from './footer/footer.component';
import {RouterModule} from '@angular/router';
import {routes} from './routes';
import { PraticienDetailConsultationComponent } from './praticien-detail-consultation/praticien-detail-consultation.component';
import { PraticienDetailEditComponent } from './praticien-detail-edit/praticien-detail-edit.component';
import { PraticienDetailEditionComponent } from './praticien-detail-edition/praticien-detail-edition.component';
import { RdvComponent } from './rdv/rdv.component';
import {RdvService} from './service/rdv.service';
import { PatientDetailConsultationComponent } from './patient-detail-consultation/patient-detail-consultation.component';
import { PatientDetailEditionComponent } from './patient-detail-edition/patient-detail-edition.component';



@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent,
    PatientComponent,
    PraticienDetailComponent,
    PatientDetailComponent,
    HeaderComponent,
    InfoPatientComponent,
    FooterComponent,
    PraticienDetailConsultationComponent,
    PraticienDetailEditComponent,
    PraticienDetailEditionComponent,
    RdvComponent,
    PatientDetailConsultationComponent,
    PatientDetailEditionComponent

  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(routes)
  ],
  providers: [PatientService, PraticienService, RdvService],
  bootstrap: [AppComponent]
})
export class AppModule { }
