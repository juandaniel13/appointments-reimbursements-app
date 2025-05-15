import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppointmentResponse } from '../../interfaces/appointment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private URL = 'http://localhost:8080/api/v1/appointment'

  constructor(private http:HttpClient) { }


  getNextAppointments(patientId: number):Observable<AppointmentResponse[]>{
    const fetch_url = `${this.URL}/nexts-appointments/${patientId}`
    return this.http.get<AppointmentResponse[]>(fetch_url);
  }
}
