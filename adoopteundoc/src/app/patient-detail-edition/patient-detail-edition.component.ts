import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../service/praticien.service';
import {Patient} from '../model/patient';
import {PatientService} from '../service/patient.service';

@Component({
  selector: 'app-patient-detail-edition',
  templateUrl: './patient-detail-edition.component.html',
  styleUrls: ['./patient-detail-edition.component.css']
})
export class PatientDetailEditionComponent implements OnInit {

  @Input('patient')
  private pat: Patient;

  @Output()
  private showConsultation = new EventEmitter();


  constructor(private patientService: PatientService) { }

  ngOnInit() {
  }

  public save() {
    this.patientService.update(this.pat).subscribe(res => {
      this.showConsultation.emit();
    });

  }
}
