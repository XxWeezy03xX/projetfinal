import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Rdv} from '../model/rdv';

@Injectable({
  providedIn: 'root'
})
export class RdvService {

  private url = 'http://localhost:8080/boot/rest/rdv';

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

  public update(rdv: Rdv): Observable<any> {
    return this.http.put(`${this.url}/${rdv.id}`, rdv, this.httpOptions);
  }

  public insert(rdv: Rdv): Observable<any> {
    const s = {
      'patient': rdv.patient,
      'praticien': rdv.praticien,
      'motif': rdv.motif,
      'lieu': rdv.lieu
    };
    return this.http.post( `${this.url}` , s, this.httpOptions);
  }
}
