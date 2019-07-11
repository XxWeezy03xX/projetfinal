import { Injectable } from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService implements CanActivate {

  private token: User = null;
  constructor(private router: Router) { }

  canActivate(): boolean {
    if (this.token !== null ) {
      return true;
    } else {
      this.router.navigate(['/login']);
    }
  }

  public login(user: User) {
    if (user.email === 'toto' && user.password === 'toto') {
      this.token = user;
      return true;
    } else {
      return false;
    }
  }
}
