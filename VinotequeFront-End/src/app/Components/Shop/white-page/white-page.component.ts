import { Component } from '@angular/core';
import { Wine } from 'src/app/Model/Wine';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-white-page',
  templateUrl: './white-page.component.html',
  styleUrls: ['./white-page.component.css']
})
export class WhitePageComponent {

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
    this.wineService.getWhiteWines().subscribe(data=> {
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
    this.wineService.getGradationWhite(Number(max)).subscribe(data => {
      this.wines = data;
    })
  }

  searchPrice(max:number){
    this.wineService.getPriceWinesWhite(max).subscribe(data => {
      this.wines = data;
    })
  }

}
