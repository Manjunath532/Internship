import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

export const AuthGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);  // Inject AuthService to check login
  const router = inject(Router);            // Inject Router to navigate if needed

  // Check if user is logged in (based on localStorage or AuthService logic)
  if (authService.isLoggedIn()) {
    return true; // ✅ Allow access
  } else {
    router.navigate(['/login']); // ❌ Redirect to login if not logged in
    return false; // Block access
  }
};
