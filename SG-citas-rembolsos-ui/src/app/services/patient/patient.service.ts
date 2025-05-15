import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PatientResponse } from '../../interfaces/patient';
import { TokenService } from '../tokenService/token.service';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  private url = 'http://localhost:8080/api/v1/patient';

  constructor(private http: HttpClient, private tokenService: TokenService) {}

  getPatientByEmail(email: string): Observable<PatientResponse> {
    const headers = new HttpHeaders({
      Authorization: `Bearer ${this.tokenService.token}`,
    });
    return this.http.get<PatientResponse>(`${this.url}/${email}`, { headers });
  }
}
