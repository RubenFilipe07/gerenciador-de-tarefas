import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  getToken(): string | null {
    return localStorage.getItem('jwtToken');
  }

  setToken(token: string): void {
    localStorage.setItem('jwtToken', token);
  }

  removeToken(): void {
    localStorage.removeItem('jwtToken');
  }

  isAuthenticated(): boolean {
    if (this.getToken()) {
      return true;
    }
    return false;
  }

  logout(): void {
    this.removeToken();
  }
}
