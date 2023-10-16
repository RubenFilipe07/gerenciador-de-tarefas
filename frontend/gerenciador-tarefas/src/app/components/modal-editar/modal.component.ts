import { Component, OnInit } from '@angular/core';
import { TarefasService } from 'src/app/services/tarefas.service';
import { UsuariosService } from 'src/app/services/usuarios.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.sass'],

})


export class ModalComponent implements OnInit {

  id: string = this.tarefasService.getId();
  titulo: string = this.tarefasService.getTitulo();
  descricao: string = this.tarefasService.getDescricao();
  situacao: string =  this.tarefasService.getSituacao();
  responsavel: string = this.tarefasService.getResponsavel();

  usuarios: any[] = [];


  constructor(public notification: NzNotificationService, public tarefasService: TarefasService, public usuariosService: UsuariosService) {
  }
  

  atualizarTarefa(id: string, titulo: string, descricao: string, situacao: string, responsavel: string) {
    this.tarefasService.atualizarTarefa(id, titulo, descricao, situacao, responsavel).subscribe(
      (res) => {
        this.mostrarMensagem('success', 'Sucesso', 'Tarefa atualizada com sucesso!');
      },
      (err) => {
        this.mostrarMensagem('error', 'Erro', 'Erro ao atualizar tarefa!');
      }
    );
  }

  getUsuarios() {
    this.usuariosService.getUsuarios().subscribe((data) => {
      this.usuarios = data;
      console.log(this.usuarios);
    });
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
