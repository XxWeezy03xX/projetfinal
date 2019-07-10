import {User} from './user';
import {Rdv} from './rdv';
import {Motif} from './motif';

export class Praticien extends User {
  constructor(private _presentation?: string, private _moyen_paiement?: string, private _avis?: string, private _note?: number, private _motifs?: Motif[], private _rdv?: Rdv[]) {
    super();
  }

  get presentation(): string {
    return this._presentation;
  }

  set presentation(value: string) {
    this._presentation = value;
  }

  get moyen_paiement(): string {
    return this._moyen_paiement;
  }

  set moyen_paiement(value: string) {
    this._moyen_paiement = value;
  }

  get avis(): string {
    return this._avis;
  }

  set avis(value: string) {
    this._avis = value;
  }

  get note(): number {
    return this._note;
  }

  set note(value: number) {
    this._note = value;
  }

  get motifs(): Motif[] {
    return this._motifs;
  }

  set motifs(value: Motif[]) {
    this._motifs = value;
  }

  get rdv(): Rdv[] {
    return this._rdv;
  }

  set rdv(value: Rdv[]) {
    this._rdv = value;
  }
}
