import { Component, Input } from '@angular/core';
import { RequestSommelier } from 'src/app/Model/RequestSommelier';

@Component({
  selector: 'app-request-card',
  templateUrl: './request-card.component.html',
  styleUrls: ['./request-card.component.css']
})
export class RequestCardComponent {
  @Input() request !: RequestSommelier;
}
