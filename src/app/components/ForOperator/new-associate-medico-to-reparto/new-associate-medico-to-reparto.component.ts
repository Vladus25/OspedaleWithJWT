import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ConnectionDBService } from 'src/app/services/connection-db.service';

@Component({
  selector: 'app-new-associate-medico-to-reparto',
  templateUrl: './new-associate-medico-to-reparto.component.html',
  styleUrls: ['./new-associate-medico-to-reparto.component.css']
})
export class NewAssociateMedicoToRepartoComponent {

  idMedico!: Number;
  idReparto!: Number;
  tuttiReparti: any;


  constructor(
    private dialogRef: MatDialogRef<NewAssociateMedicoToRepartoComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { idMedico: number }, private http: ConnectionDBService
  ) {
    this.idMedico = data.idMedico;
  }

  ngOnInit(){
    this.getTuttiReparti();
  }

  getTuttiReparti() {
    this.http.getTuttiReparti().subscribe(data => {
      this.tuttiReparti = data;
    });
  }

  submitForm() {
    const nuovaAssociazione = {
      idMedico: this.idMedico,
      idReparto: this.idReparto
    };

    // Invia il risultato al componente padre
    this.dialogRef.close(nuovaAssociazione);
  }

  cancel() {
    this.dialogRef.close();
  }
}
