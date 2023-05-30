import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';

@Component({
  selector: 'app-all-esami',
  templateUrl: './all-esami.component.html',
  styleUrls: ['./all-esami.component.css']
})
export class AllEsamiComponent {

  tuttiEsami:any;

  constructor(private http: ConnectionDBService) { }

  ngOnInit(){
    this.getTuttiEsami();
  }

  getTuttiEsami() {
    this.http.getTuttiEsami().subscribe(data => {
      this.tuttiEsami = data;
    });
  }
}
