import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit{

  ngOnInit(): void {
  }

  @Input() isHandset: any;
}