import { Component, Input, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';

@Component({
  selector: 'app-wine-view',
  templateUrl: './wine-view.component.html',
  styleUrls: ['./wine-view.component.css']
})

export class WineViewComponent implements OnInit{
  ngOnInit(): void {

  }
  @Input() isHandset: any;
}
