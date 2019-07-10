import {User} from './user';
import {Rdv} from './rdv';

export class Adresse {
  constructor(private _id?: number, private _numero?: number, private _rue?: string, private _cp?: string, private _ville?: string, private _user?: User, private _rdv?: Rdv) {

  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get numero(): number {
    return this._numero;
  }

  set numero(value: number) {
    this._numero = value;
  }

  get rue(): string {
    return this._rue;
  }

  set rue(value: string) {
    this._rue = value;
  }

  get cp(): string {
    return this._cp;
  }

  set cp(value: string) {
    this._cp = value;
  }

  get ville(): string {
    return this._ville;
  }

  set ville(value: string) {
    this._ville = value;
  }

  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
  }

  get rdv(): Rdv {
    return this._rdv;
  }

  set rdv(value: Rdv) {
    this._rdv = value;
  }
}
