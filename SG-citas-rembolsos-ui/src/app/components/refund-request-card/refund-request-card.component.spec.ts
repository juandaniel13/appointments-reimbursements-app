import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RefundRequestCardComponent } from './refund-request-card.component';

describe('RefundRequestCardComponent', () => {
  let component: RefundRequestCardComponent;
  let fixture: ComponentFixture<RefundRequestCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RefundRequestCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RefundRequestCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
