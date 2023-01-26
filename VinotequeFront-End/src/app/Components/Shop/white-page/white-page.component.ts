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
}
