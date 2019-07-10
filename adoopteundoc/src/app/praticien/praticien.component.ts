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

  }
}
