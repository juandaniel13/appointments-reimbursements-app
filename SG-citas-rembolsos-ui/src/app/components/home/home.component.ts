import { Component, Input } from '@angular/core';
import { AsideMenuComponent } from '../aside-menu/aside-menu.component';
import { TokenService } from '../../services/tokenService/token.service';
import { NextAppointmentsComponent } from "../next-appointments/next-appointments.component";
import { PatientService } from '../../services/patient/patient.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AsideMenuComponent, NextAppointmentsComponent],
  providers:[TokenService],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  patientEmail!: string;
  patientId!:number;

  constructor(private tokenService: TokenService, private patientService: PatientService){

  }

  ngOnInit(){
    this.patientEmail = this.tokenService.getEmailFromToken()
    this.patientService.getPatientByEmail(this.patientEmail).subscribe({
      next:(res) =>{
        this.patientId = res.id;
      },
      error:(err) => {
        console.log(err);
        
      }
    })
    
  }

}
