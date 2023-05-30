import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';
import { MatDialog } from '@angular/material/dialog';
import { AddPazienteDialogComponent } from '../add-paziente-dialog/add-paziente-dialog.component';
import { ModificaPazienteDialogComponent } from '../modifica-paziente-dialog/modifica-paziente-dialog.component';

@Component({
  selector: 'app-all-pazienti',
  templateUrl: './all-pazienti.component.html',
  styleUrls: ['./all-pazienti.component.css']
})
export class AllPazientiComponent {
  pazienti: any[] = [];
  delPazzienteResponse: any;

  constructor(private http: ConnectionDBService, private dialog: MatDialog) {}

  ngOnInit(){
    this.getTuttiPazienti();
  }

  getTuttiPazienti(){
    this.http.getTuttiPazienti().subscribe(data => {
      this.pazienti = data;
    });
  }

  deletePaziente(id: number) {
    const confirmDelete = window.confirm('Sei sicuro di voler eliminare il paziente?');

    if (confirmDelete) {
      this.http.deletePaziente(id).subscribe(() => {
        this.getTuttiPazienti();
      });
    }
  }

  addPaziente() {
    const dialogRef = this.dialog.open(AddPazienteDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      this.http.addPaziente(result).subscribe((result:any) => {
        console.log(result);
        this.getTuttiPazienti();
      });
    });
  }

  modificaPaziente(id: number, paziente: any) {
    // Apri il dialog di modifica paziente
    const dialogRef = this.dialog.open(ModificaPazienteDialogComponent, {
      data: paziente,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        // Esegui l'aggiornamento del paziente
        this.http.modificaPaziente(id, result).subscribe(() => {
          // Aggiorna la lista dei pazienti dopo la modifica
          this.getTuttiPazienti();
        });
      }
    });
  }
}
