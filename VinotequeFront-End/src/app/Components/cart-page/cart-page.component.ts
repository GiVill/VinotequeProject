import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { reduce } from 'rxjs';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit{

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
  ngOnInit(): void {
    window.paypal.Buttons({
      style:{
        layout: 'horizontal'
      }
    }).render(this.payPalRef.nativeElement);
  }

}
