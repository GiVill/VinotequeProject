import { ChangeDetectorRef, Component, ElementRef, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, NgForm, Validators } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ICreateOrderRequest, IPayPalConfig } from 'ngx-paypal';
import { reduce } from 'rxjs';
import { Cart } from 'src/app/Model/Cart';
import { Order } from 'src/app/Model/Order';
import { Promotion } from 'src/app/Model/Promotion';
import { User } from 'src/app/Model/User';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { OrederService } from 'src/app/Services/oreder.service';


@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit, OnChanges{

  constructor(private service:AuthenticationService,
              private cdr: ChangeDetectorRef,
              private _snackBar: MatSnackBar,
              private orderService: OrederService,){}


  public payPalConfig?: IPayPalConfig;

  cart !: Cart

  user !: User

  order !: Order

  promo !: Promotion

  showSpinner : boolean = false

  showEndMessage : boolean = false

  message !: String;

  confirmOrder() {
    this.showSpinner = true;
    setTimeout(() => {
      this.showSpinner = false;
      if (this.cart.totale==0){
        this.showEndMessage = true;
        this.message = "Il carrello è vuoto";
      }
      else{
        this.showEndMessage = true;
        this.message = "Il tuo ordine è stato preso in carico!"
      }
    }, 2500); // Show the component for 2500 milliseconds (2.5 seconds)
  }

  paga(){

  }

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

    this.initConfig();

    //     AGGIORNA CARRELLO SALVANDONE LO STATO NEL DB     //
    this.cart = JSON.parse(sessionStorage.getItem("cart")!);

    if(this.service.currentUser?.carrello != sessionStorage.getItem("cart")){
      this.service.addCart(this.cart)
    }

    this.user = JSON.parse(localStorage.getItem("user")!)

    //     MOSTRA PAYPAL BUTTON?     //
  }

  reload(newMessage: string) {
    if(newMessage == "cart"){
      this.cart = JSON.parse(sessionStorage.getItem("cart")!);
    }
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
      this.promo = {
        id : 1,
        descrizione: "default",
        sconto_prezzo : 0
      }
    }
    //TODO:
  }


  newOrder(){
    let metodoPag : String
    if(this.paypalMethod){
      metodoPag = "PayPal"
    } else {
      metodoPag = "Contrassegno"
    }

    let indirizzo = `${this.user.via} ${this.user.civico} ${this.user.cap}`

    this.order = {
      id: 10,
      ordine_utente : this.user,
      ordine_carrello : JSON.stringify(sessionStorage.getItem("cart")),
      metodo_pag : metodoPag,
      indirizzo : indirizzo,
      totale : this.cart.totale,
      status : "new",
      ordine_promozione : this.promo,
      data : new Date().toLocaleDateString()
    }
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.cart = JSON.parse(sessionStorage.getItem("cart")!);
  }


  private initConfig(): void {
    this.payPalConfig = {
    currency: 'EUR',
    clientId: 'AfFgTUDYhQVeOJ9yHqSwz2lClsoH3eS7wXUuC3tzODmByw6yB3lIl7yWXHbg0cpmqkcswjlVOqHWJ_oh',
    createOrderOnClient: (data) => <ICreateOrderRequest>{
      intent: 'CAPTURE',
      purchase_units: [
        {
          amount: {
            currency_code: 'USD',
            value: this.cart.totale.toString(),
            breakdown: {
              item_total: {
                currency_code: 'USD',
                value: this.cart.totale.toString()
              }
            }
          },
        }
      ]
    },
    style: {
      label: 'paypal',
      layout: 'vertical'
    },
    onApprove: (data, actions) => {
      console.log('onApprove - transaction was approved, but not authorized', data, actions);
      actions.order.get().then((details: any) => {
        console.log('onApprove - you can get full order details inside onApprove: ', details);
      });
    },
    onClientAuthorization: (data) => {
      this.orderService.postOrder(this.order).subscribe(data =>{
        if(data){
          this._snackBar.open("Ordine completato!","OK");
          // sessionStorage.removeItem("cart")
        }
      })
    },
    onCancel: (data, actions) => {
      console.log('OnCancel', data, actions);
    },
    onError: err => {
      console.log('OnError', err);
    },
  };
  }
}
