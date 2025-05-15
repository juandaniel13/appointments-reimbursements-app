import { HttpClient, HttpContext } from '@angular/common/http';
import { ApplicationConfig, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthParams, AuthRequest, AuthResponse } from '../../interfaces/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService  {

  constructor(private http: HttpClient) { }

  private AUTH_PATH = 'http://localhost:8080/api/v1/auth/authorization'

  authenticate(params: AuthRequest): Observable<AuthResponse>{
   // const rb = new RequestBuilder()
   return this.http.post<AuthResponse>(this.AUTH_PATH, params);

  }
}
