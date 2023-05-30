import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

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

  getTuttiEsami(): Observable<any> {
    return this.http.get(`${this.baseUrl}/esame_laboratorio/all`);
  }

  getTuttiVisite(): Observable<any> {
    return this.http.get(`${this.baseUrl}/visite_pazienti/all`);
  }

  getTuttiMedici(): Observable<any> {
    return this.http.get(`${this.baseUrl}/medico/all`);
  }

  getTuttiReparti(): Observable<any> {
    return this.http.get(`${this.baseUrl}/reparto/all`);
  }

  getTuttiPazienti(): Observable<any> {
    return this.http.get(`${this.baseUrl}/paziente/all`);
  }

  addPaziente(paziente: any):Observable<any> {
    return this.http.post(`${this.baseUrl}/paziente/add`, paziente);
  }

  deletePaziente(id: number){
    return this.http.delete<any>(`${this.baseUrl}/paziente/delete/${id}`).pipe(
      tap(response => {
        console.log(response.message);
      })
    );
  }

  modificaPaziente(id:number, paziente: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/paziente/update/${id}`, paziente);
  }

  downloadPdf(id: Number): Observable<HttpResponse<Blob>> {
    const url = `${this.baseUrl}/paziente/download-pdf/${id}`;
    return this.http.get(url, {
      responseType: 'blob',
      observe: 'response'
    });
  }
}
