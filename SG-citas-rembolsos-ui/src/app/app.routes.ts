import { Routes } from '@angular/router';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    {
        path:'',
        title:'login',
        component: LoginComponent
    },
    {
        path:'welcome',
        title:'welcome',
        component: WelcomePageComponent
    },
    {
        path:"home",
        title:'home',
        component: HomeComponent
    }
];
