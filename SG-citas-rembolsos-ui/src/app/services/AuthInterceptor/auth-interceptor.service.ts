import { Injectable } from '@angular/core';
import { TokenService } from '../tokenService/token.service';

@Injectable({
  providedIn: 'root'
})

export class AuthInterceptorService {

  constructor(private tokenService: TokenService) { 
    
  }

 /*  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const token = this.tokenService.getToken();

    if (token) {
      const cloned = req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + token)
      });
      return next.handle(cloned);
    }

    return next.handle(req);
  } */
}
