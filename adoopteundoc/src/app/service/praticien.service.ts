import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Praticien} from '../model/praticien';

@Injectable({
  providedIn: 'root'
})
export class PraticienService {

  private url = 'http://localhost:8080/boot/rest/praticien';

  private httpHeaders: HttpHeaders;

  private httpOptions: any;

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({'Content-Type': 'application/json', Authorization: 'Basic ' + btoa('toto:toto')})

    this.httpOptions = {headers: this.httpHeaders};
  }

  public list(): Observable<any> {
    return this.http.get(this.url, this.httpOptions);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, this.httpOptions);
  }

  public update(praticien: Praticien): Observable<any> {
    return this.http.put(`${this.url}/${praticien.id}`, praticien, this.httpOptions);
  }

  public insert(praticien: Praticien): Observable<any> {
    const s = {
      'prenom': praticien.prenom,
      'nom': praticien.nom,
      'email': praticien.email,
      'presentation': praticien.presentation,
      'moyen_paiement': praticien.moyen_paiement,
      'avis': praticien.avis,
      'motifs': praticien.motifs,
      'rdv': praticien.rdv,
      'note': praticien.note
    };
    return this.http.post( `${this.url}` , s, this.httpOptions);
  }
}
