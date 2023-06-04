import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ConnectionDBService } from 'src/app/services/connection-db.service';
import { AssociateMedicoRepartoComponent } from '../associate-medico-reparto/associate-medico-reparto.component';

@Component({
  selector: 'app-all-reparti',
  templateUrl: './all-reparti.component.html',
  styleUrls: ['./all-reparti.component.css']
})
export class AllRepartiComponent {

  tuttiReparti:any;

  constructor(private http: ConnectionDBService) { }

  ngOnInit(){
    this.getTuttiReparti();
  }

  getTuttiReparti() {
    this.http.getTuttiReparti().subscribe(data => {
      this.tuttiReparti = data;
    });
  }

}
