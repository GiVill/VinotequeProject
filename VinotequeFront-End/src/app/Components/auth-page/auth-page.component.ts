import { Component } from '@angular/core';
import { MatButton, MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-auth-page',
  templateUrl: './auth-page.component.html',
  styleUrls: ['./auth-page.component.css']
})
export class AuthPageComponent {
  hideRegistration : boolean = true


  onClick() {
    this.hideRegistration = !this.hideRegistration;
  }
}
