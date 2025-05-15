import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NextAppointmentsComponent } from './next-appointments.component';

describe('NextAppointmentsComponent', () => {
  let component: NextAppointmentsComponent;
  let fixture: ComponentFixture<NextAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NextAppointmentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NextAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
