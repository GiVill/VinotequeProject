import { Component, Input } from '@angular/core';
import { RequestSommelier } from 'src/app/Model/ReuestSommelier';

@Component({
  selector: 'app-request-card',
  templateUrl: './request-card.component.html',
  styleUrls: ['./request-card.component.css']
})

export class RequestCardComponent {
  @Input() request !: RequestSommelier;
}
