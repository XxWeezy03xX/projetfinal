import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Patient} from "../model/patient";
import {PatientService} from "../service/patient.service";

@Component({
  selector: '[lignePatient]',
  templateUrl: './patient-detail.component.html',
  styleUrls: ['./patient-detail.component.css']
})
export class PatientDetailComponent implements OnInit {

  @Input('patient')
  private pat: Patient;

  @Output()
  private patientRefresh = new EventEmitter();

  private oldPatient: Patient;

  private edit = false;

  constructor(private patientService: PatientService) {

  }

  ngOnInit() {

    if (!this.pat.id) {
      this.edit = true;
    }

  }

  public edition() {
    this.edit = true;
    this.oldPatient = new Patient(this.pat.naissance, this.pat.secu, this.pat.rdv)
  }

  public save() {

    if (!this.pat.id) {
      this.patientService.insert(this.pat).subscribe(res => {
        this.patientRefresh.emit();
      });
    } else {
      this.patientService.update(this.pat).subscribe(res => {
        this.consultation();
      });
    }
  }

  public cancel() {
    this.pat = this.oldPatient;
    this.consultation();
  }

  public consultation() {
    this.edit = false;
  }

  public delete (id: number) {
    this.patientService.delete(id).subscribe(res => {
      this.patientRefresh.emit();
    });
  }

}
