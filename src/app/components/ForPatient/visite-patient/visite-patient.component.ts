import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-visite-patient',
  templateUrl: './visite-patient.component.html',
  styleUrls: ['./visite-patient.component.css']
})
export class VisitePatientComponent {

  constructor(private http: ConnectionDBService, private tokenStorageService: TokenStorageService ) { }

  user!: number;
  visitePaziente: any;

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser().id;
    this.getVisitePaziente(this.user);
  }

  getVisitePaziente(user: number) {
    this.http.getVisitePaziente(user).subscribe(data => {
      this.visitePaziente = data;
    });
  }
}
