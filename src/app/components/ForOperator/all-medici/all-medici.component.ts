import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';

@Component({
  selector: 'app-all-medici',
  templateUrl: './all-medici.component.html',
  styleUrls: ['./all-medici.component.css']
})
export class AllMediciComponent {

  tuttiMedici:any;

  constructor(private http: ConnectionDBService) { }

  ngOnInit(){
    this.getTuttiMedici();
  }

  getTuttiMedici() {
    this.http.getTuttiMedici().subscribe(data => {
      this.tuttiMedici = data;
    });
  }
}
