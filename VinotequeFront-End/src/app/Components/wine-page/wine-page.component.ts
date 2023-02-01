import { NgFor } from '@angular/common';
import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
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
              private reviewService: ReviewService,
              private cdr: ChangeDetectorRef){}

  wine !: Wine
  user !: User
  reviews !: Review[]
  canAddReview : boolean = false;
  index !: string | null ;

  ngOnInit(): void {

    window.scrollY

    if(this.authService.isLogged()){
      if(this.authService.currentUser != null)
        this.user = this.authService.currentUser;
      if(this.authService.isSommelier()){
        this.canAddReview = true;
      } else{
        this.canAddReview = false;
      }
    }

    this.index = this.route.snapshot.paramMap.get("index")

    if(this.wineService.wines != undefined || null){
      this.wine = this.wineService.wines[Number(this.index)];
      this.takeReviews();

    } else {
      this.wineService.getWines().subscribe(data =>{
        this.wineService.wines = data
        this.wine = this.wineService.wines[Number(this.index)];
        this.takeReviews();
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


  takeReviews(){
    this.reviewService.getReviews(this.wine.id).subscribe(data =>{
      this.reviewService.review = data;
      this.reviews = data;
    })
  }

  onSubmit(form:NgForm){

    let descrizione = "caiodasd djasbvdasvd asdvasjhd a sd"
    console.log(descrizione)
    let data = new Date().toLocaleDateString();
    let id = 10

    const recensione : Review = {
      id : 10,
      descrizione : descrizione,
      recensione_sommelier : JSON.parse(localStorage.getItem("user")!),
      recensione_vino : this.wine,
      data : data,
    }

    this.reviewService.postReview(recensione).subscribe(data =>{
      if(data){
        this.cdr.detectChanges();
      }
    })
  }
}