import { ChangeDetectorRef, Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { RequestSommelier } from 'src/app/Model/RequestSommelier';
import { User } from 'src/app/Model/User';
import { Wine } from 'src/app/Model/Wine';
import { RequestService } from 'src/app/Services/request.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit{

  constructor(private service: WineService,
              private serviceRequest: RequestService){}



  reload(newMessage: string) {
    if(newMessage == "preferiti"){
      this.service.getFavorites(this.utente.id).subscribe(data =>{
        this.favorites = data;
        console.log(this.favorites)
      })
    }
  }

  ngOnInit(): void {

    this.utente = JSON.parse(localStorage.getItem("user")!);

    this.service.getFavorites(this.utente.id).subscribe(data =>{
      this.favorites = data;
      console.log(this.favorites)
    })

    if (this.utente.ruolo=='UTENTE'){
      this.serviceRequest.getRequests().subscribe(data =>{
        this.requestsSommelier = data;
      })
    }
  }

  showUserPage = true;
  showOrdersPage = false;
  showFavoritesPage = false;
  showBecomeSommelier = false;
  showRequest = false;

  utente !: User

  favorites !: Wine[]

  requestsSommelier !: RequestSommelier[]

  clickUser(){
    this.showOrdersPage = false
    this.showUserPage = true
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = false
  }

  clickOrders(){
    this.showOrdersPage = true
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = false
  }


  clickFavorites(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = true
    this.showBecomeSommelier = false
    this.showRequest = false
  }

  clickBecomeSommelier(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = true
    this.showRequest = false
  }

  clickViewRequest(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = true
  }
}
