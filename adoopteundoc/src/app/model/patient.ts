import {User} from './user';
import {Rdv} from './rdv';

export class Patient extends User{
  constructor(private _naissance?: Date, private _secu?: number, private _rdv?: Rdv[]) {
    super();
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
