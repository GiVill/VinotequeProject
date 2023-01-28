import { Component, ElementRef, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { reduce } from 'rxjs';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit, OnChanges{

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
    window.paypal.Buttons({
      style:{
        layout: 'horizontal'
      }
    }).render(this.payPalRef.nativeElement);
  }

  ngOnChanges(changes: SimpleChanges): void {
    window.paypal.Buttons({
      style:{
        layout: 'horizontal'
      }
    }).render(this.payPalRef.nativeElement);
  }

}
