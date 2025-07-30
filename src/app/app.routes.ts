import { Routes } from '@angular/router';
import { provideRouter } from '@angular/router';
import { LoginComponent } from './pages/login.component';
import { SignupComponent } from './pages/signup.component';
import { TodoComponent } from './pages/todo.component';
import { AuthGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'todo', component: TodoComponent, canActivate: [AuthGuard] }
];

export const routing = provideRouter(routes);
