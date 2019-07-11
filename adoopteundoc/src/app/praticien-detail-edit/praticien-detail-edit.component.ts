import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../service/praticien.service';

@Component({
  selector: 'app-praticien-detail-edit',
  templateUrl: './praticien-detail-edit.component.html',
  styleUrls: ['./praticien-detail-edit.component.css']
})
export class PraticienDetailEditComponent implements OnInit {

  @Input('praticien')
  private p: Praticien;
  @Output()
  private showConsultation = new EventEmitter();

  constructor(private praticienService: PraticienService) { }

  ngOnInit() {
  }

  public save() {
    this.praticienService.update(this.p).subscribe(res => {
      this.showConsultation.emit();
    });
  }

}
