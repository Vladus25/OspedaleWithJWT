import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-esami-patient',
  templateUrl: './esami-patient.component.html',
  styleUrls: ['./esami-patient.component.css']
})
export class EsamiPatientComponent {

  constructor(private http: ConnectionDBService, private tokenStorageService: TokenStorageService ) { }

  user!: number;
  esamiPaziente: any;

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser().id;
    this.getEsamiPaziente(this.user);
  }

  getEsamiPaziente(user: number) {
    this.http.getEsamiPaziente(user).subscribe(data => {
      this.esamiPaziente = data;
    });
  }
}
