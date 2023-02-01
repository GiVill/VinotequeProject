import { ResourceLoader } from '@angular/compiler';
import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { Cart, removeWine } from 'src/app/Model/Cart';
import { Favorite } from 'src/app/Model/Favorite';
import { Wine } from 'src/app/Model/Wine';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-item-cart',
  templateUrl: './item-cart.component.html',
  styleUrls: ['./item-cart.component.css']
})
export class ItemCartComponent implements OnInit{

  constructor(private service:WineService,
              private cdr: ChangeDetectorRef){}

  wine !: Wine

  ngOnInit(): void {

    this.service.getWineById(this.idWine).subscribe(data =>{
      console.log(data)
      this.wine = data
      this.quantity = this.cart.quantity[this.index.valueOf()]
    })
  }


  removeItem(){
    removeWine(this.cart,this.wine)
    sessionStorage.setItem("cart",JSON.stringify(this.cart)!)
    console.log(this.cart)
  }

  createFavorite(){
    const favorite : Favorite = {
      preferiti_utente : JSON.parse(localStorage.getItem("user")!),
      preferiti_vino : this.wine
    }

    this.service.addFavorite(favorite).subscribe(data =>{
      if (data){
        this.cdr.detectChanges();
      }
    })
  }


  @Input() idWine !: BigInt ;

  @Input() index !: Number ;
  @Input() cart !: Cart ;

  quantity = 0
}
