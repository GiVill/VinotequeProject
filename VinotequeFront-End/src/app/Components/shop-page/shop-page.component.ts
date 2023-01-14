import { Component, Input, OnInit } from '@angular/core';
import { WineService } from 'src/app/Services/wine.service';
import { Wine } from 'src/app/Wine';

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit{
  constructor(private wineService:WineService){}
  wines !: Wine[]

  ngOnInit(): void {
    this.wineService.getWines().subscribe(data=> {
      this.wines = data;
      console.log(data)
    })
  }

  @Input() isHandset: any;
}
