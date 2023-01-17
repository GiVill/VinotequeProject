import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { WineService } from 'src/app/Services/wine.service';
import { User } from 'src/app/Model/User';
import { Wine } from 'src/app/Model/Wine';
import { ReviewService } from 'src/app/Services/review.service';
import { Review } from 'src/app/Model/Review';

@Component({
  selector: 'app-wine-page',
  templateUrl: './wine-page.component.html',
  styleUrls: ['./wine-page.component.css']
})
export class WinePageComponent implements OnInit{

  constructor(private route : ActivatedRoute,
              private wineService : WineService,
              private authService : AuthenticationService,
              private reviewService: ReviewService){}

  wine !: Wine
  user !: User
  reviews !: Review[]
  canAddReview : boolean = false;
  id : string | null | undefined;



  ngOnInit(): void {

    if(this.authService.isLogged()){
      this.user = this.authService.currentUser;
      if(this.authService.isSommelier()){
        this.canAddReview = true;
      } else{
        this.canAddReview = false;
      }
    }

    this.id = this.route.snapshot.paramMap.get("id")

    if(!this.wineService.wines){
      this.wineService.getWines().subscribe(data=> {
        this.wineService.wines = data;
        this.wine = this.wineService.wines[Number(this.id)-1];
        this.reviewService.getReviews(this.wine.id).subscribe(data =>{
          this.reviewService.review = data;
          this.reviews = data;
        })
      })

    } else {
      this.wine = this.wineService.wines[Number(this.id)-1];
      this.reviewService.getReviews(this.wine.id).subscribe(data =>{
        this.reviewService.review = data;
        this.reviews = data;
      })
    }
  }

  show = false;

  sendReviewButton(value: string) {
    if (value.length > 0) {
      this.show = true;
    } else {
      this.show = false;
    }
  }

  onSubmit(from:NgForm){

  }
}
