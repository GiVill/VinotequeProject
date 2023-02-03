import { Component } from '@angular/core';
import { Wine } from 'src/app/Model/Wine';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-red-page',
  templateUrl: './red-page.component.html',
  styleUrls: ['./red-page.component.css']
})
export class RedPageComponent {

  constructor(private wineService:WineService){}
  wines !: Wine[]

  filterPrice : Boolean = false;
  filterGradation : Boolean = false;

  maxValue = 100;

  ngOnInit(): void {
    window.scrollY;
    this.takeWines()
  }

  takeWines(){
    this.wineService.getRedWines().subscribe(data=> {
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

