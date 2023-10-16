import { Component } from '@angular/core';
import { MenuComponent } from 'src/app/components/menu/menu.component';
import { FooterComponent } from 'src/app/components/footer/footer.component';
import { UsuariosService } from 'src/app/services/usuarios.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Login } from 'src/app/models/login.model';
import { Router } from '@angular/router';

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

  email: string = "";
  senha: string = "";

  constructor(public usuariosService: UsuariosService, private notification: NzNotificationService, private router: Router) { }

  loginUsuario() {
    const novoLogin = new Login(this.email, this.senha);

    this.usuariosService.loginUsuario(novoLogin).subscribe(
      (res) => {
        this.router.navigate(['/']);
        this.mostrarMensagem('success', 'Sucesso', 'Login realizado com sucesso!');
       
      },
      (err) => {
        console.log(err);
        this.mostrarMensagem('error', 'Erro', 'Erro ao realizar login!');
      }
    );
  }

  mostrarMensagem(tipo: string, titulo: string, mensagem: string) {
    switch (tipo) {
      case 'success':
        this.notification.success(titulo, mensagem);
        break;
      case 'error':
        this.notification.error(titulo, mensagem);
        break;
    }

  }
}