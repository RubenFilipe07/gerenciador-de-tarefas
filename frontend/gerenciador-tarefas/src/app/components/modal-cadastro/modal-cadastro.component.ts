import { Component, OnInit } from '@angular/core';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { TarefasService } from 'src/app/services/tarefas.service';
import { UsuariosService } from 'src/app/services/usuarios.service';

@Component({
  selector: 'app-modal-cadastro',
  templateUrl: './modal-cadastro.component.html',
  styleUrls: ['./modal-cadastro.component.sass']
})
export class ModalCadastroComponent implements OnInit {

  id: string = "";
  titulo: string = "";
  descricao: string = "";
  situacao: string = "";
  responsavel: string = "";
  prioridade: string = "";
  deadline: string = "";

  usuarios: any[] = [];

  constructor(public notification: NzNotificationService, public tarefasService: TarefasService, public usuariosService: UsuariosService) {
  }

  getUsuarios() {
    this.usuariosService.getUsuarios().subscribe((data) => {
      this.usuarios = data;
      console.log(this.usuarios);
    });
  }

  cadastrarTarefa(titulo: string, descricao: string, prioridade: string, situacao: string, responsavel: string, deadline: string) {
    this.tarefasService.cadastrarTarefa(titulo, descricao, situacao, prioridade, responsavel, deadline).subscribe(
      (res) => {
        this.mostrarMensagem('success', 'Sucesso', 'Tarefa cadastrada com sucesso!');
        console.log(res);
      },
      (err) => {
        console.log(err);
        this.mostrarMensagem('error', 'Erro', 'Erro ao cadastrar tarefa!');
      }
    );
  }

    mostrarMensagem(tipo: string, titulo: string, mensagem: string) {
      switch (tipo) {
        case 'success':
          this.notification
            .success(
              titulo,
              mensagem
            )
          break;
        case 'error':
          this.notification
            .error(
              titulo,
              mensagem
            )
          break;
      }
  
    }
    

  ngOnInit(): void {
    this.getUsuarios();
  }

}
