import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../service/praticien.service';
import {Adresse} from '../model/adresse';

@Component({
  selector: 'lignePraticien',
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
    this.oldPraticien = new Praticien(this.p.id, this.p.prenom,
      this.p.nom, this.p.email, this.p.presentation, this.p.adresse, this.p.moyen_paiement, this.p.avis, this.p.note, this.p.motifs, this.p.rdv);
  }

  public save() {
    if (!this.s.id) {
      this.soldatService.insert(this.s).subscribe(res => {
        this.soldatRefresh.emit();
      });
    } else {
      this.soldatService.update(this.s).subscribe(res => {
        this.consultation();
      });
    }
  }

  public cancel() {
    this.s = this.oldSoldat;
    this.consultation();
  }

  public consultation() {
    this.edit = false;
  }

  public delete(id: number) {
    this.soldatService.delete(id).subscribe(res => {
      this.soldatRefresh.emit();
    });
  }
