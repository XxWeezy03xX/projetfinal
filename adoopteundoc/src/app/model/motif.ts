import {Praticien} from './praticien';
import {Rdv} from './rdv';

export class Motif {
  constructor(private _id?: number, private _motif?: string, private _prix?: number, private _praticien?: Praticien, private _rdv?: Rdv) {

  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get motif(): string {
    return this._motif;
  }

  set motif(value: string) {
    this._motif = value;
  }

  get prix(): number {
    return this._prix;
  }

  set prix(value: number) {
    this._prix = value;
  }

  get praticien(): Praticien {
    return this._praticien;
  }

  set praticien(value: Praticien) {
    this._praticien = value;
  }

  get rdv(): Rdv {
    return this._rdv;
  }

  set rdv(value: Rdv) {
    this._rdv = value;
  }
}
