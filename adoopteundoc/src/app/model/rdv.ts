import {Patient} from './patient';
import {Praticien} from './praticien';
import {Motif} from './motif';
import {Adresse} from './adresse';

export class Rdv {
  constructor(private _id?: number, private _patient?: Patient, private _praticien?: Praticien, private _motif?: Motif, private _lieu?: Adresse) {

  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get patient(): Patient {
    return this._patient;
  }

  set patient(value: Patient) {
    this._patient = value;
  }

  get praticien(): Praticien {
    return this._praticien;
  }

  set praticien(value: Praticien) {
    this._praticien = value;
  }

  get motif(): Motif {
    return this._motif;
  }

  set motif(value: Motif) {
    this._motif = value;
  }

  get lieu(): Adresse {
    return this._lieu;
  }

  set lieu(value: Adresse) {
    this._lieu = value;
  }
}
