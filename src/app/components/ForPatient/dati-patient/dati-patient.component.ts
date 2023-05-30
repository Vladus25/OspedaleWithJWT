import { HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-dati-patient',
  templateUrl: './dati-patient.component.html',
  styleUrls: ['./dati-patient.component.css']
})
export class DatiPatientComponent {

  constructor(private http: ConnectionDBService, private tokenStorageService: TokenStorageService ) { }

  user!: number;
  datiPaziente: any;


  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser().id;
    console.log(this.user)
    this.getdatiPaziente(this.user);
  }

  getdatiPaziente(user: number) {
    this.http.getDatiPaziente(user).subscribe(data => {
      this.datiPaziente = data;
    });
  }

  downloadPdf(pazienteId: Number): void {
    this.http.downloadPdf(pazienteId)
      .subscribe(response => {
        this.savePdf(response);
      }, error => {
        console.error('Error downloading PDF:', error);
      });
  }


  private savePdf(response: HttpResponse<Blob>): void {
    const filename = 'Esito-Paziente.pdf';
    const blobPart: BlobPart = response.body as any;

    if (blobPart !== null) {
      const blob = new Blob([blobPart], { type: 'application/pdf' });
      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.download = filename;
      link.click();
      window.URL.revokeObjectURL(url);
    } else {
      console.error('PDF not found.');
    }
  }
}
