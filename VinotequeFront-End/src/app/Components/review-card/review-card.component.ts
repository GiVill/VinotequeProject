import { Component, Input, OnInit } from '@angular/core';
import { Review } from 'src/app/Model/Review';

@Component({
  selector: 'app-review-card',
  templateUrl: './review-card.component.html',
  styleUrls: ['./review-card.component.css']
})

export class ReviewCardComponent implements OnInit{

  ngOnInit(): void {
  }

  @Input() review !: Review ;
}
