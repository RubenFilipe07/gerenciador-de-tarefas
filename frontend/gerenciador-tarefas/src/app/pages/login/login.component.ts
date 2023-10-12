import { Component } from '@angular/core';
import { MenuComponent } from 'src/app/components/menu/menu.component';
import { FooterComponent } from 'src/app/components/footer/footer.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass'],
  providers: [
    MenuComponent,
    FooterComponent
  
  ]
})
export class LoginComponent {

}
