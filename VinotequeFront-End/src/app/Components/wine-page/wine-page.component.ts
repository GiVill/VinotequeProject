import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { WineService } from 'src/app/Services/wine.service';
import { Wine } from 'src/app/Wine';

@Component({
  selector: 'app-wine-page',
  templateUrl: './wine-page.component.html',
  styleUrls: ['./wine-page.component.css']
})
export class WinePageComponent implements OnInit{

  constructor(private route : ActivatedRoute,
              private wineService : WineService){}

  wine !: Wine;
  id : string | null | undefined;



  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get("id")

    if(!this.wineService.wines){
      if(!this.wineService.wines){

        this.wineService.getWines().subscribe(data=> {
          this.wineService.wines = data;
          this.wine = this.wineService.wines[Number(this.id)-1];

        })
      }
    } else {

      this.wine = this.wineService.wines[Number(this.id)-1];
    }
  }

  show = false;

  showButton(value: string) {
    if (value.length > 0) {
      this.show = true;
    } else {
      this.show = false;
    }
  }

  onSubmit(from:NgForm){

  }
}
