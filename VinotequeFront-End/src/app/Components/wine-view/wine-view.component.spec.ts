import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WineViewComponent } from './wine-view.component';

describe('WineViewComponent', () => {
  let component: WineViewComponent;
  let fixture: ComponentFixture<WineViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WineViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WineViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
