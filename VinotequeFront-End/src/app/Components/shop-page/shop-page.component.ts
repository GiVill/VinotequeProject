import { Component, Input, OnInit } from '@angular/core';
import { WineService } from 'src/app/Services/wine.service';
import { Wine } from 'src/app/Model/Wine';

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit{

  constructor(private wineService:WineService){}
  wines !: Wine[]

  ngOnInit(): void {

    window.scrollY

    if(!(this.wineService.wines != undefined || null)){
      this.takeWines();
    } else {
      this.wines = this.wineService.wines
    }
  }



  takeWines(){
    this.wineService.getWines().subscribe(data=> {
      this.wines = data;
      this.wineService.wines = data;
    })
  }

  @Input() isHandset: any;
}
