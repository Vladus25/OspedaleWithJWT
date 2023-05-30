import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnectionDBService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getDatiPaziente(userID: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/paziente/dati/${userID}`);
  }

  getEsamiPaziente(userID: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/esame_laboratorio/esami/${userID}`);
  }

  getVisitePaziente(userID: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/visite_pazienti/visite/${userID}`);
  }

  downloadPdf(id: Number): Observable<HttpResponse<Blob>> {
    const url = `${this.baseUrl}/paziente/download-pdf/${id}`;
    return this.http.get(url, {
      responseType: 'blob',
      observe: 'response'
    });
  }
}
