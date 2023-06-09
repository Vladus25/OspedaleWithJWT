import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  API_URL:string = 'http://localhost:8080/api/test/';

  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(this.API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(this.API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(this.API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(this.API_URL + 'admin', { responseType: 'text' });
  }

  getPersone(){
    return this.http.get(`${this.API_URL}getPersone`);
  }

  getRicette(){
    return this.http.get(`${this.API_URL}getRicette`);
  }

  inviaRicetta(ricetta: any): Observable<any> {
    return this.http.post(`${this.API_URL}addRicetta`, ricetta);
  }

  getIngredienti(){
    return this.http.get(`${this.API_URL}getIngredienti`);
  }
}
