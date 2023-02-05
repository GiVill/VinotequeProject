import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { Review } from 'src/app/Model/Review';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { ReviewService } from 'src/app/Services/review.service';

@Component({
  selector: 'app-review-card',
  templateUrl: './review-card.component.html',
  styleUrls: ['./review-card.component.css']
})

export class ReviewCardComponent implements OnInit{

  constructor(private authService: AuthenticationService,
              private reviewService: ReviewService){}

  ngOnInit(): void {
    if(this.authService.isLogged()){
      if(this.authService.isAdmin())
        this.canDel = true;
      else if(this.authService.isSommelier() &&
      this.authService.currentUser?.id == this.review.recensione_sommelier.id){
        this.canDel = true;
      }
    }
  }

  delReview(){
    this.reviewService.delReview(this.review).subscribe(data =>{
      if(data){
        this.valueChanged.emit('recensione');
      }
    })
  }

  canDel = false;
  @Input() review !: Review ;
  @Output() valueChanged = new EventEmitter<string>();
}
