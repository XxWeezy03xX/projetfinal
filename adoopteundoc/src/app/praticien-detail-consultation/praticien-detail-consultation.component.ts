import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';

@Component({
  selector: 'app-praticien-detail-consultation',
  templateUrl: './praticien-detail-consultation.component.html',
  styleUrls: ['./praticien-detail-consultation.component.css']
})
export class PraticienDetailConsultationComponent implements OnInit {

  @Input('praticien')
  private p: Praticien;

  @Output()
  private showEdit = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit() {
  }

  public edition() {
    this.showEdit.emit(true);
  }

}
