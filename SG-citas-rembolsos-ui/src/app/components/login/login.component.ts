import { Component, NgModule } from '@angular/core';
import {
  NgModel,
  FormsModule,
  NgForm,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthError, AuthRequest } from '../../interfaces/auth';
import { AuthService } from '../../services/authService/auth.service';
import { TokenService } from '../../services/tokenService/token.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  providers:[AuthService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  authResquest: AuthRequest = {
    email: '',
    password: '',
  };

  errorMsg: Array<AuthError> = [];

  constructor(
    private router: Router,
    private authService: AuthService,
    private tokenService: TokenService
  ) {}

  login() {
    this.errorMsg = [];
    console.log(this.authResquest);
    
    this.authService.authenticate(this.authResquest).subscribe({
      next: (res) => {
        //Token service se enccarga de guardar el token en el local storage
        this.tokenService.token = res.token as string;
        this.router.navigate(['home']);
      },
      error: (err: AuthError) => {
        console.log(err);
        /* if (err.code > 400) {
          this.errorMsg = err;
        } else {
          this.errorMsg.push({});
        } */
      },
    });
  }
}
