import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { addWine, Cart, upload } from 'src/app/Model/Cart';
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
      if(sessionStorage.getItem("cart") == null || sessionStorage.getItem("cart") == "null"){
        let cart : Cart = {idUtente:this.service.currentUser.id, vini: [], quantity: [], totale:0 }
        addWine(cart,this.wine,1)
        sessionStorage.setItem("cart",JSON.stringify(cart))
      } else {
        let cart = JSON.parse(sessionStorage.getItem("cart")!);
        upload(cart,this.wine)
        sessionStorage.setItem("cart",JSON.stringify(cart))
      }
    }
  }
}
