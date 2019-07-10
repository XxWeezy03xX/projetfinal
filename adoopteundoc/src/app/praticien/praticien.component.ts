import { Component, OnInit } from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../service/praticien.service';


@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrls: ['./praticien.component.css']
})
export class PraticienComponent implements OnInit {

  private praticiens: Praticien[] = [];

  constructor(private praticienService: PraticienService) { }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.praticienService.list().subscribe(res => {
      this.praticiens = res;
    });
  }

  public delete(id: number) {
    this.praticienService.delete(id).subscribe(res => {
      this.list();
    });
  }

  public add() {
    this.praticiens.push(new Praticien());
  }
}
