import { Component } from '@angular/core';
import { Wine } from 'src/app/Model/Wine';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-rose-page',
  templateUrl: './rose-page.component.html',
  styleUrls: ['./rose-page.component.css']
})
export class RosePageComponent {

  constructor(private wineService:WineService){}
  wines !: Wine[]

  ngOnInit(): void {
    window.scrollY;
    this.takeWines()
  }

  takeWines(){
    this.wineService.getRoseWines().subscribe(data=> {
      this.wines = data;
      this.wineService.wines = data;
    })
  }
}
