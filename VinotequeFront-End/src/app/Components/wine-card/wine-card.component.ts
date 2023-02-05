import { ChangeDetectorRef, Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { addWine, Cart, getWineQuantity, upload } from 'src/app/Model/Cart';
import { Favorite, removeFromArray } from 'src/app/Model/Favorite';
import { User } from 'src/app/Model/User';
import { Wine } from 'src/app/Model/Wine';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-wine-card',
  templateUrl: './wine-card.component.html',
  styleUrls: ['./wine-card.component.css']
})

export class WineCardComponent implements OnInit{

  constructor(private service:AuthenticationService,
              private wineService:WineService,
              private _snackBar: MatSnackBar){}


  @Input() wine !: Wine ;

  @Input() index!: BigInt;

  @Output() valueChanged = new EventEmitter<string>();

  isPreferito : Boolean = false

  user !: User
  favorites !: BigInt[]


  ngOnInit(): void {

    if(this.service.isLogged()){
      this.user = JSON.parse(localStorage.getItem("user")!)
      this.isPreferito = this.service.isInFavorites(Number(this.index))
    }
  }

  favorite(){

    if(this.service.isLogged()){

      if(this.isPreferito){
        this.isPreferito = false
        const favorite : Favorite = {
          preferiti_utente : this.user,
          preferiti_vino : this.wine
        }

        this.service.favourites = removeFromArray(this.service.favourites,Number(this.index))
        this.wineService.delFavorite(favorite).subscribe(data =>{
          if(data){
            this.valueChanged.emit('preferiti');
            this._snackBar.open("Prodotto rimosso dai preferit!","OK");
          }
        })

      } else {
        this.isPreferito = true

        const favorite : Favorite = {
        preferiti_utente : JSON.parse(localStorage.getItem("user")!),
        preferiti_vino : this.wine
        }

        this.service.favourites.push(Number(this.index))
        this.wineService.addFavorite(favorite).subscribe(data =>{
          if(data){
            this._snackBar.open("Prodotto aggiunto ai preferiti!","OK");
          }
        })
      }

    } else {
      this._snackBar.open("Non sei loggato!","OK");
    }
  }

  addCart(){
    if(!this.service.isLogged()){
      this._snackBar.open("Non sei loggato!", "OK");
    } else {
      let cart = JSON.parse(sessionStorage.getItem("cart")!);
      if(getWineQuantity(cart,this.wine) == 10){
        this._snackBar.open("Hai già la quantità massima nel carrello!","OK");
      } else {
        upload(cart,this.wine)
        sessionStorage.setItem("cart",JSON.stringify(cart))
        this._snackBar.open("Prodotto aggiunto al carrello!","OK");
      }
    }
  }
}
