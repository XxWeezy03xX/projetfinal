import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Patient} from '../model/patient';

@Component({
  selector: 'app-patient-detail-consultation',
  templateUrl: './patient-detail-consultation.component.html',
  styleUrls: ['./patient-detail-consultation.component.css']
})
export class PatientDetailConsultationComponent implements OnInit {

  @Input('patient')
  private pat: Patient;

  @Output()
  private showEdit = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit() {
  }

  public edition() {
    this.showEdit.emit(true);
  }

}
