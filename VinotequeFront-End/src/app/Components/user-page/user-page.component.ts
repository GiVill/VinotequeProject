import { ChangeDetectorRef, Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cantina } from 'src/app/Model/Cantina';
import { RequestSommelier } from 'src/app/Model/RequestSommelier';
import { User } from 'src/app/Model/User';
import { Wine } from 'src/app/Model/Wine';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { RequestService } from 'src/app/Services/request.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit{

  constructor(private service: WineService,
              private serviceRequest: RequestService,
              private authService: AuthenticationService,
              private _snackBar: MatSnackBar){}

  reload(newMessage: string) {
    if(newMessage == "preferiti"){
      this.service.getFavorites(this.utente.id).subscribe(data =>{
        this.favorites = data;
      })
    }
  }

  ngOnInit(): void {

    this.utente = JSON.parse(localStorage.getItem("user")!);
    this.indirizzo = (`${this.utente.via} ${this.utente.civico} ${this.utente.cap}`)

    this.service.getFavorites(this.utente.id).subscribe(data =>{
      this.favorites = data;
      console.log(this.favorites)
    })

    if (this.utente.ruolo=='ADMIN'){
      this.serviceRequest.getRequests().subscribe(data =>{
        this.requestsSommelier = data;
      })
    }
  }

  createWine(_nome:String,_annata:String,_prezzo:String,_gradazione:String,_tipologia:string,_cantina:Cantina,_premi:String,_descrizione:String,_vigneto:String,_immagine:Blob){
    const wine : Wine = {
      id : BigInt(10),
      nome : _nome,
      annata : Number(_annata),
      prezzo : Number(_prezzo),
      gradazione_alcolica : Number(_gradazione),
      tipologia : _tipologia,
      vino_cantina : null,
      premi : _premi,
      descrizione : _descrizione,
      vigneto : _vigneto,
      foto : _immagine
    }

    this.service.addWine(wine).subscribe(data=>{
      if (data){
        this._snackBar.open("Il vino è stato aggiunto", "OK")
      }
      else{
        this._snackBar.open("Errore, riprova più tardi","OK")
      }
    })

  }

  showUserPage = true;
  showOrdersPage = false;
  showFavoritesPage = false;
  showBecomeSommelier = false;
  showRequest = false;
  showChangePassword = false;
  showAddWine = false;

  indirizzo !: String

  utente !: User

  favorites !: Wine[]

  requestsSommelier !: RequestSommelier[]

  clickUser(){
    this.showOrdersPage = false
    this.showUserPage = true
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = false
    this.showChangePassword = false
    this.showAddWine = false
  }

  clickOrders(){
    this.showOrdersPage = true
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = false
    this.showChangePassword = false
    this.showAddWine = false
  }


  clickFavorites(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = true
    this.showBecomeSommelier = false
    this.showRequest = false
    this.showChangePassword = false
    this.showAddWine = false
  }

  clickBecomeSommelier(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = true
    this.showRequest = false
    this.showChangePassword = false
    this.showAddWine = false
  }

  clickViewRequest(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = true
    this.showChangePassword = false
    this.showAddWine = false
  }

  clickChangePassword(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = false
    this.showChangePassword = true
    this.showAddWine = false
  }

  clickViewAddWine(){
    this.showOrdersPage = false
    this.showUserPage = false
    this.showFavoritesPage = false
    this.showBecomeSommelier = false
    this.showRequest = false
    this.showChangePassword = false
    this.showAddWine = true
  }

  changePassword(utente: User, pass1 : String, pass2 : String){
    if (pass1 != pass2){
      this._snackBar.open("Le password non corrispondono");
    }
    else{
      this.authService.changePassword(utente,pass2).subscribe( data =>{
        if (data){
          this._snackBar.open("Password cambiata!", "OK")
        }
        else{
          this._snackBar.open("Errore, riprova più tardi", "OK")
        }
      })
    }
  }

  createSommelierRequest(_matricola:String){
    const richiesta : RequestSommelier = {
      id : 14,
      utente : this.utente,
      matricola : _matricola
    }

    this.serviceRequest.sendRequest(richiesta).subscribe( data =>{
      if (data){
        this._snackBar.open("Richiesta inviata!","OK");
      }
      else{
        this._snackBar.open("Attendi che la tua richiesta venga elaborata!", "OK");
      }
    })

  }

}
