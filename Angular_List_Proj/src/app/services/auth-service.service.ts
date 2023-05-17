import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthServiceService {
  role!: string;
  isLoggedIn: boolean = true;

  constructor() {}
  setRole(role: string) {
    this.role = role;
  }
  isAuthenticated() {
    if (this.role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
}
