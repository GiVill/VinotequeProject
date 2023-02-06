import { Component, OnInit } from '@angular/core';
import { Promotion } from 'src/app/Model/Promotion';
import { Review } from 'src/app/Model/Review';
import { Wine } from 'src/app/Model/Wine';
import { OrderService } from 'src/app/Services/order.service';
import { ReviewService } from 'src/app/Services/review.service';
import { WineService } from 'src/app/Services/wine.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private service:WineService,
              private reviewService:ReviewService,
              private orderService:OrderService){}

  wines !: Wine[]

  promo !: Promotion

  review !: Review

  index : number = 0

  wineID !: BigInt

  ngOnInit(): void {


    this.orderService.getRandomPromoCode().subscribe(data =>{
      if(data){
        this.promo = data
      }
    })

    this.service.getRandomWine().subscribe(data =>{
      this.wines = data
      this.takeReviews(this.wines[0])
      this.wineID = this.wines[0].id
    })

  }

  takeReviews(wine:Wine){
    this.reviewService.getRandomReviews(wine.id).subscribe(data =>{
      this.review = data
    })
  }

  back(){

    if(this.index == 0){
      this.index = 3
    }
    this.index -= 1
    this.takeReviews(this.wines[this.index])
    this.wineID = this.wines[this.index].id
  }

  next(){
    if(this.index == 2){
      this.index = -1
    }
    this.index += 1
    this.takeReviews(this.wines[this.index])
    this.wineID = this.wines[this.index].id
  }
}
