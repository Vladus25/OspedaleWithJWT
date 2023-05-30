import { Component } from '@angular/core';
import { ConnectionDBService } from 'src/app/services/connection-db.service';

@Component({
  selector: 'app-all-visite',
  templateUrl: './all-visite.component.html',
  styleUrls: ['./all-visite.component.css']
})
export class AllVisiteComponent {

  tuttiVisite:any;

  constructor(private http: ConnectionDBService) { }

  ngOnInit(){
    this.getTuttiVisite();
  }

  getTuttiVisite() {
    this.http.getTuttiVisite().subscribe(data => {
      this.tuttiVisite = data;
    });
  }
}
