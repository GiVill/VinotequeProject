import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { addWine, Cart, getWineQuantity, upload } from 'src/app/Model/Cart';
import { Wine } from 'src/app/Model/Wine';
import { AuthenticationService } from 'src/app/Services/authentication.service';

@Component({
  selector: 'app-wine-card',
  templateUrl: './wine-card.component.html',
  styleUrls: ['./wine-card.component.css']
})

export class WineCardComponent implements OnInit {

  constructor(private service:AuthenticationService,
              private _snackBar: MatSnackBar){}

  @Input() wine !: Wine ;

  @Input() index!: Number;

  ngOnInit(): void {

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
