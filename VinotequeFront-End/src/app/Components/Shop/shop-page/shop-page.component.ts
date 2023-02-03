import { Component, Input, OnInit } from '@angular/core';
import { WineService } from 'src/app/Services/wine.service';
import { Wine } from 'src/app/Model/Wine';
import { Event } from '@angular/router';

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit{

  constructor(private wineService:WineService){}

  wines !: Wine[]

  filterPrice : Boolean = false;
  filterGradation : Boolean = false;

  maxValue = 100;

  ngOnInit(): void {

    window.scrollY
    this.takeWines()
  }

  takeWines(){
    this.wineService.getWines().subscribe(data=> {
      this.wines = data;
      this.wineService.wines = data;
    })
  }

  openRangePrezzo(){
    this.filterPrice = true;
    this.filterGradation = false;
  }

  openRangeGradation(){
    this.filterPrice = false;
    this.filterGradation = true;
  }

  searchGradation(){
    const input = document.getElementById('valueGradation') as HTMLInputElement | null;
    const max = input?.value;
    this.wineService.getGradation(Number(max)).subscribe(data => {
      this.wines = data;
    })
  }

  searchPrice(max:number){
    this.wineService.getPriceWines(max).subscribe(data => {
      this.wines = data;
    })
  }

}
