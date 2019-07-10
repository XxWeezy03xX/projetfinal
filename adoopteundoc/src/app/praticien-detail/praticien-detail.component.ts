import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../service/praticien.service';

@Component({
  selector: '[lignePraticien]',
  templateUrl: './praticien-detail.component.html',
  styleUrls: ['./praticien-detail.component.css']
})
export class PraticienDetailComponent implements OnInit {

  @Input('praticien')
  private p: Praticien;

  @Output()
  private praticienRefresh = new EventEmitter();

  private oldPraticien: Praticien;

  private edit = false;

  constructor(private praticienService: PraticienService) { }

  ngOnInit() {
    if (!this.p.id) {
      this.edit = true;
    }
  }

  public edition() {
    this.edit = true;
    this.oldPraticien = new Praticien(this.p.presentation, this.p.moyen_paiement, this.p.avis, this.p.note, this.p.motifs, this.p.rdv);
  }

  public save() {
    if (!this.p.id) {
      this.praticienService.insert(this.p).subscribe(res => {
        this.praticienRefresh.emit();
      });
    } else {
      this.praticienService.update(this.p).subscribe(res => {
        this.consultation();
      });
    }
  }

  public cancel() {
    this.p = this.oldPraticien;
    this.consultation();
  }

  public consultation() {
    this.edit = false;
  }

  public delete(id: number) {
    this.praticienService.delete(id).subscribe(res => {
      this.praticienRefresh.emit();
    });
  }
}
