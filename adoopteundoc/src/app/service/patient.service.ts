import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Patient} from '../model/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private url = 'http://localhost:8080/boot/rest/patient';

  private httpHeaders: HttpHeaders;

  private httpOptions : any;

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

  public update(patient: Patient): Observable<any> {
    return this.http.put(`${this.url}/${patient.id}`, patient, this.httpOptions);
  }

  public insert(patient: Patient): Observable<any> {
    const s = {
      'prenom': patient.prenom,
      'nom': patient.nom,
      'email': patient.email,
      'naissance': patient.naissance,
      'secu': patient.secu,
      'rdv': patient.rdv
    };
    return this.http.post( `${this.url}` , s, this.httpOptions);
  }
}
