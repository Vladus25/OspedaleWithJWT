import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';
import { MatDialog } from '@angular/material/dialog';
import { NewAssociateMedicoToRepartoComponent } from '../new-associate-medico-to-reparto/new-associate-medico-to-reparto.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-medici',
  templateUrl: './all-medici.component.html',
  styleUrls: ['./all-medici.component.css']
})
export class AllMediciComponent {

  tuttiMedici: any;

  constructor(private http: ConnectionDBService, private dialog: MatDialog, private router: Router) { }

  ngOnInit() {
    this.getTuttiMedici();
  }

  getTuttiMedici() {
    this.http.getTuttiMedici().subscribe(data => {
      this.tuttiMedici = data;
    });
  }

  addMedicoAdReparto(idMedico: number) {
    const dialogRef = this.dialog.open(NewAssociateMedicoToRepartoComponent, {
      data: { idMedico: idMedico }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log(result);
        const idReparto = result.idReparto;
        this.http.addMedicoAdReparto(idMedico, idReparto).subscribe((result: any) => {
          console.log(result);
          this.router.navigate(['/All-Reparti']);
        });
      }
    });
  }

}
