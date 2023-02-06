import { Component, Input } from '@angular/core';
import { Order } from 'src/app/Model/Order';

@Component({
  selector: 'app-order-card',
  templateUrl: './order-card.component.html',
  styleUrls: ['./order-card.component.css']
})

export class OrderCardComponent {

  @Input() order !: Order ;

}
