import { Component, OnInit } from '@angular/core';
import {Praticien} from '../model/praticien';

@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrls: ['./praticien.component.css']
})
export class PraticienComponent implements OnInit {

  private praticiens: Praticien[] = [];

  constructor() { }

  ngOnInit() {

  }
}
