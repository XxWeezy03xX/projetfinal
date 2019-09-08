import { Component, OnInit } from '@angular/core';
import {Rdv} from '../model/rdv';
import {RdvService} from '../service/rdv.service';

@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.css']
})
export class RdvComponent implements OnInit {

  private rdvs: Rdv[] = [];
  constructor(private rdvService = RdvService) { }

  ngOnInit() {

  }

}
