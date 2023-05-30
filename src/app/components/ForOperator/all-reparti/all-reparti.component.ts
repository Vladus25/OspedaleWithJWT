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

  constructor(private http: ConnectionDBService, private dialog: MatDialog) { }

  ngOnInit(){
    this.getTuttiReparti();
  }

  getTuttiReparti() {
    this.http.getTuttiReparti().subscribe(data => {
      this.tuttiReparti = data;
    });
  }

  // addMedicoAdReparto(idReparto: number) {
  //   const dialogRef = this.dialog.open(AssociateMedicoRepartoComponent);

  //   dialogRef.afterClosed().subscribe(result => {
  //     console.log(result);
  //     this.http.addPaziente(idReparto, result).subscribe((result:any) => {
  //       console.log(result);
  //       this.getTuttiReparti();
  //     });
  //   });
  // }
}
