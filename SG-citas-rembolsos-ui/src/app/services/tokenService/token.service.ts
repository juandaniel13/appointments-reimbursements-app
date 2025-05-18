import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  set token(token: string){
    localStorage.setItem('token', token);
  }

  get token(){
    return localStorage.getItem('token') as string;
  }

  getEmailFromToken(){
    if(this.token){
      const decoded: any = jwtDecode(this.token);
      console.log("token", decoded);
      return decoded.fullName;
    

    }
  }
}
