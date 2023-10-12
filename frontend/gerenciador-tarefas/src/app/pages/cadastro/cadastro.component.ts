import { Component } from '@angular/core';
import { MenuComponent } from 'src/app/components/menu/menu.component';
import { FooterComponent } from 'src/app/components/footer/footer.component';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.sass'],
  providers: [
    MenuComponent,
    FooterComponent
  
  ]
})

export class CadastroComponent {

}
