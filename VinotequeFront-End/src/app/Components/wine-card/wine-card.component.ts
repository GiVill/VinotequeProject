import { Component, Input, OnInit } from '@angular/core';
import { addWine, Cart } from 'src/app/Model/Cart';
import { Wine } from 'src/app/Model/Wine';
import { AuthenticationService } from 'src/app/Services/authentication.service';

@Component({
  selector: 'app-wine-card',
  templateUrl: './wine-card.component.html',
  styleUrls: ['./wine-card.component.css']
})

export class WineCardComponent implements OnInit {

  constructor(private service:AuthenticationService){}

  @Input() wine !: Wine ;

  @Input() index!: Number;

  ngOnInit(): void {

  }

  addCart(){
    if(sessionStorage.getItem("cart")== null || ""){
      let cart : Cart = { vini: [], quantity: [] }
      addWine(cart,this.wine.id,1)
      sessionStorage.setItem("cart",JSON.stringify(cart).toString())
    } else {
      console.log("PARSE"+JSON.parse(sessionStorage.getItem("cart")!))
      let cart = JSON.parse(sessionStorage.getItem("cart")!);
      console.log(">>>>>>>>>"+cart)
      addWine(cart,this.wine.id,1)
      sessionStorage.setItem("cart",JSON.stringify(cart))
    }

  }
}
