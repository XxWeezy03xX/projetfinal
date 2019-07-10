import {User} from './user';
import {Rdv} from './rdv';
import {Adresse} from './adresse';

export class Patient extends User {
  constructor(private _naissance?: Date, private _secu?: number, private _rdv?: Rdv[],  _id?: number, _nom?: string, _prenom?: string, _email?: string, _adresse?: Adresse[]) {
    super(_id, _nom, _prenom, _email, _adresse);
  }

  get naissance(): Date {
    return this._naissance;
  }

  set naissance(value: Date) {
    this._naissance = value;
  }

  get secu(): number {
    return this._secu;
  }

  set secu(value: number) {
    this._secu = value;
  }

  get rdv(): Rdv[] {
    return this._rdv;
  }

  set rdv(value: Rdv[]) {
    this._rdv = value;
  }
}
