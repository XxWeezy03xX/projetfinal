import {Adresse} from './adresse';

export abstract class User {

  constructor(private _id?: number, private _nom?: string, private _prenom?: string, private _email?: string, public _adresse?: Adresse[]) {




  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get adresse(): Adresse[] {
    return this._adresse;
  }

  set adresse(value: Adresse[]) {
    this._adresse = value;
  }
}
