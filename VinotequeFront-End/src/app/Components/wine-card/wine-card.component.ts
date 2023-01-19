import { Component, Input, OnInit } from '@angular/core';
import { Wine } from 'src/app/Model/Wine';

@Component({
  selector: 'app-wine-card',
  templateUrl: './wine-card.component.html',
  styleUrls: ['./wine-card.component.css']
})
export class WineCardComponent implements OnInit {

  @Input() wine !: Wine ;

  @Input() index!: Number;

  ngOnInit(): void {

  }

}
