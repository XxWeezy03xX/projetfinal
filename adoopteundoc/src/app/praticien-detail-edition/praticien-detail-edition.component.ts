import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../service/praticien.service';
import {Adresse} from '../model/adresse';

@Component({
  selector: 'app-praticien-detail-edition',
  templateUrl: './praticien-detail-edition.component.html',
  styleUrls: ['./praticien-detail-edition.component.css']
})
export class PraticienDetailEditionComponent implements OnInit {

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
