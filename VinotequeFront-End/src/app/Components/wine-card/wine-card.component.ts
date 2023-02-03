import { ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { addWine, Cart, getWineQuantity, upload } from 'src/app/Model/Cart';
import { Favorite } from 'src/app/Model/Favorite';
import { Wine } from 'src/app/Model/Wine';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-wine-card',
  templateUrl: './wine-card.component.html',
  styleUrls: ['./wine-card.component.css']
})

export class WineCardComponent implements OnInit {

  constructor(private service:AuthenticationService,
              private wineService:WineService,
              private _snackBar: MatSnackBar){}

  @Input() wine !: Wine ;

  @Input() index!: BigInt;

  @Input() preferito !:  number;

  @Output() valueChanged = new EventEmitter<string>();

  isPreferito !: Boolean;


  ngOnInit(): void {

    if(this.preferito == -1){
      this.isPreferito = false;

    } else if( this.preferito == 1 ){
      this.isPreferito = true
    }
  }

  createFavorite(){

    if (this.preferito == 0){
      this.isPreferito = true

      const favorite : Favorite = {
        preferiti_utente : JSON.parse(localStorage.getItem("user")!),
        preferiti_vino : this.wine
      }

      this._snackBar.open("Prodotto aggiunto ai preferiti!","OK");

      this.wineService.addFavorite(favorite).subscribe(data =>{
      })

    } else if(this.preferito == -1) {

      this.isPreferito = true

      const favorite : Favorite = {
        preferiti_utente : JSON.parse(localStorage.getItem("user")!),
        preferiti_vino : this.wine
      }

      this.wineService.addFavorite(favorite).subscribe(data =>{
        if(data){
          this._snackBar.open("Prodotto aggiunto ai preferiti!","OK");
        } else {
          this._snackBar.open("Prodotto già presente nei preferiti!","OK");
        }
      })

    } else {

      this.isPreferito = false

      const favorite : Favorite = {
        preferiti_utente : JSON.parse(localStorage.getItem("user")!),
        preferiti_vino : this.wine
      }

      this.wineService.delFavorite(favorite).subscribe(data =>{
        if(data){
          this.valueChanged.emit('preferiti');
        }
      })

    }

  }

  addCart(){
    if(!this.service.isLogged()){
      this._snackBar.open("Non sei loggato!", "OK");
    } else {
      let cart = JSON.parse(sessionStorage.getItem("cart")!);
      if(getWineQuantity(cart,this.wine) == 10){
        this._snackBar.open("Hai già la quantità massima nel carrello!");
      } else {
        upload(cart,this.wine)
        sessionStorage.setItem("cart",JSON.stringify(cart))
        this._snackBar.open("Prodotto aggiunto al carrello!");
      }
    }
  }
}
