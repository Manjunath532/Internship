import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface SignupPayload {
  fullName: string;
  email: string;
  password: string;
}

interface LoginPayload {
  email: string;
  password: string;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:9999/api/auth';

  constructor(private http: HttpClient) {}

  signup(data: SignupPayload): Observable<string> {
    return this.http.post(`${this.baseUrl}/signup`, data, { responseType: 'text' });
  }

  login(email: string, password: string): Observable<string> {
    const payload: LoginPayload = { email, password };
    return this.http.post(`${this.baseUrl}/login`, payload, { responseType: 'text' });
  }

  markAsLoggedIn(): void {
    localStorage.setItem('loggedIn', 'true');
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('loggedIn') === 'true';
  }

  logout(): void {
    localStorage.removeItem('loggedIn');
  }
}
