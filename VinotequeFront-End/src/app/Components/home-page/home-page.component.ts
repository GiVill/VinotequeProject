import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/Model/Review';
import { Wine } from 'src/app/Model/Wine';
import { ReviewService } from 'src/app/Services/review.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private service:WineService,
              private reviewService:ReviewService){}

  wines !: Wine[]
  reviews !: Review[]

  index : number = 0

  ngOnInit(): void {

    this.service.getWines().subscribe(data =>{
      this.wines = data
      this.wines.forEach(wine => {
        this.takeReviews(wine)
      });
    })

  }

  takeReviews(wine:Wine){
    this.reviewService.getReviews(wine.id).subscribe(data =>{
      this.reviewService.review = data;
      this.reviews = data;
    })
  }

  back(){
    this.index -= 1
    console.log(this.index)
  }

  next(){
    this.index += 1
  }
}
