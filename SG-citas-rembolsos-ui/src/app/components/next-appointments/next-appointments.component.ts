import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';
import { NgModel } from '@angular/forms';
import { AppointmentService } from '../../services/appointment/appointment.service';
import { log } from 'console';

@Component({
  selector: 'app-next-appointments',
  standalone: true,
  imports: [NgFor],
  providers:[AppointmentService],
  templateUrl: './next-appointments.component.html',
  styleUrl: './next-appointments.component.scss'
})
export class NextAppointmentsComponent {

  @Input()
  patientId!: number;

  constructor(private appointMentService: AppointmentService){

  }

  ngOnInit(){


    
  }

}
