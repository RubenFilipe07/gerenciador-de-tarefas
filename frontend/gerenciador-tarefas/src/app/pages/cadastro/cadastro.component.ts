import { Component } from '@angular/core';
import { UsuariosService } from 'src/app/services/usuarios.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Usuario } from 'src/app/models/usuario.model';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.sass']
})

export class CadastroComponent {

  nome: string = "";
  email: string = "";
  senha: string = "";
  role: string = "";

  constructor(public usuariosService: UsuariosService, private notification: NzNotificationService) { }

  cadastrarUsuario() {
    const novoUsuario = new Usuario(this.nome, this.email, this.senha, this.role);
  
    this.usuariosService.cadastrarUsuario(novoUsuario).subscribe(
      (res) => {
        this.mostrarMensagem('success', 'Sucesso', 'Usuário cadastrado com sucesso!');
        console.log(res);
      },
      (err) => {
        console.log(err);
        this.mostrarMensagem('error', 'Erro', 'Erro ao cadastrar usuário!');
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
