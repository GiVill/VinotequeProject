import { ResourceLoader } from '@angular/compiler';
import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Cart, removeWine } from 'src/app/Model/Cart';
import { Favorite, removeFromArray } from 'src/app/Model/Favorite';
import { Wine } from 'src/app/Model/Wine';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-item-cart',
  templateUrl: './item-cart.component.html',
  styleUrls: ['./item-cart.component.css']
})
export class ItemCartComponent implements OnInit{

  constructor(private service:WineService,
              private authService:AuthenticationService,
              private _snackBar: MatSnackBar){}

  wine !: Wine
  isPreferito : Boolean = false

  ngOnInit(): void {

    this.service.getWineById(this.idWine).subscribe(data =>{
      console.log(data)
      this.wine = data
      this.isPreferito = this.authService.isInFavorites(Number(this.wine.id))
      this.quantity = this.cart.quantity[this.index.valueOf()]
    })
  }


  removeItem(){
    removeWine(this.cart,this.wine)
    sessionStorage.setItem("cart",JSON.stringify(this.cart)!)
  }

  favorite(){

    if(this.isPreferito){
      this.isPreferito = false
      const favorite : Favorite = {
        preferiti_utente : JSON.parse(localStorage.getItem("user")!),
        preferiti_vino : this.wine
      }

      this.authService.favourites = removeFromArray(this.authService.favourites,Number(this.index))

      this.service.delFavorite(favorite).subscribe(data =>{
        if(data){
          this._snackBar.open("Prodotto rimosso dai preferit!","OK");
        }
      })

    } else {
      this.isPreferito = true

      const favorite : Favorite = {
      preferiti_utente : JSON.parse(localStorage.getItem("user")!),
      preferiti_vino : this.wine
      }

      this.authService.favourites.push(Number(this.index!))
      this.service.addFavorite(favorite).subscribe(data =>{
        if(data){
          this._snackBar.open("Prodotto aggiunto ai preferiti!","OK");
        }
      })
    }
  }


  @Input() idWine !: BigInt ;

  @Input() index !: Number ;
  @Input() cart !: Cart ;

  quantity = 0
}
