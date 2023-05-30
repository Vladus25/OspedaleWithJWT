import { Component } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  roles!: string[];
  hiddenRoles!: string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.roles = this.tokenStorageService.getUser().roles;
    const firstRole = this.roles[0];
    this.hiddenRoles = firstRole.substring(5);
  }
}
