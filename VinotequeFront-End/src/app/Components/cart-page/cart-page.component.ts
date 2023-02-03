import { ChangeDetectorRef, Component, ElementRef, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';
import { reduce } from 'rxjs';
import { Cart } from 'src/app/Model/Cart';
import { Promotion } from 'src/app/Model/Promotion';
import { User } from 'src/app/Model/User';
import { AuthenticationService } from 'src/app/Services/authentication.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit, OnChanges{

  constructor(private service:AuthenticationService,
              private cdr: ChangeDetectorRef,
              private _snackBar: MatSnackBar){}

  cart !: Cart

  user !: User

  paga(){

  }

  @ViewChild('payPalRef', {static:true}) private payPalRef:ElementRef | any;
  /*

  ACCOUNT PAYPAL CHE INVIA I SOLDI:
              EMAIL:
  sb-p1p6n24930638@personal.example.com
              PASSWORD:
  #y1nM+0X

   */

  paypalMethod = true;

  setPaypal(){
    this.paypalMethod = true;
  }

  setNormal(){
    this.paypalMethod = false;
  }


  ngOnInit(): void {

    //     AGGIORNA CARRELLO SALVANDONE LO STATO NEL DB     //
    this.cart = JSON.parse(sessionStorage.getItem("cart")!);

    if(this.service.currentUser?.carrello != sessionStorage.getItem("cart")){
      this.service.addCart(this.cart)
    }

    this.user = JSON.parse(localStorage.getItem("user")!)

    //     MOSTRA PAYPAL BUTTON?     //
    window.paypal.Buttons({
      style:{
        layout: 'horizontal'
      }
    }).render(this.payPalRef.nativeElement);
  }


  checkAddress(form : NgForm){
    //     MODIFICA I DATI DELL'UTENTE SALVATI NEL DB SE L'UTETE LI CAMBIA IN FASE DI ACQUISTO     //
    if(form.dirty){

      this.user.via = form.value.via
      this.user.civico = form.value.civico
      this.user.cap = form.value.cap
      this.user.telefono = form.value.telefono

      this.service.updateUser(this.user).subscribe(data =>{
        if(data){
          this._snackBar.open("Dati utente aggiornati!","OK");
        }
      })
      localStorage.setItem("user",JSON.stringify(this.user))
    }
  }


  checkPromo(promoInput : HTMLInputElement){
    if(promoInput.value.length == 0){
      //TODO:
    }
    //TODO:
  }


  newOrder(){
    //TODO:
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.cdr.detectChanges();
    window.paypal.Buttons({
      style:{
        layout: 'horizontal'
      }
    }).render(this.payPalRef.nativeElement);
  }

}
