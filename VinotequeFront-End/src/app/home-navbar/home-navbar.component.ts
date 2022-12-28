import { Component } from '@angular/core';

@Component({
  selector: 'app-home-navbar',
  templateUrl: './home-navbar.component.html',
  styleUrls: ['./home-navbar.component.css']
})
export class HomeNavbarComponent {
  smallScreen = false;
  searchTerm = '';

  ngOnInit() {
    this.checkScreenSize();
    window.addEventListener('resize', this.checkScreenSize.bind(this));
  }

  checkScreenSize() {
    this.smallScreen = window.innerWidth < 600;
  }

  search() {
    // eseguire la ricerca con il termine di ricerca
  }
}
