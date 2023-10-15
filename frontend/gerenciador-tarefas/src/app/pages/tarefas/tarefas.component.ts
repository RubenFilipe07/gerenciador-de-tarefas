import { Component, OnInit } from '@angular/core';
import { TarefasService } from '../../services/tarefas.service';
import { UsuariosService } from '../../services/usuarios.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { NzModalService } from 'ng-zorro-antd/modal';
import { ModalComponent } from 'src/app/components/modal-editar/modal.component';
import { ModalCadastroComponent } from 'src/app/components/modal-cadastro/modal-cadastro.component';


@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.sass'],
}

)
export class TarefasComponent implements OnInit {

  id: string = ""
  titulo: string  = "";
  descricao: string  = "";
  situacao: string  = "";
  responsavel: string  = "";

  tarefas: any[] = [];
  usuarios: any[] = [];
  isVisible = false;

  constructor(public tarefasService: TarefasService, public usuariosService: UsuariosService, private notification: NzNotificationService, public modalService: NzModalService) {
  
  }

  abrirModalEditar(id: string, titulo: string, descricao: string, situacao: string, responsavel: string) {
    this.tarefasService.setId(id);
    this.tarefasService.setTitulo(titulo);
    this.tarefasService.setDescricao(descricao);
    this.tarefasService.setSituacao(situacao);
    this.tarefasService.setResponsavel(responsavel);

    this.modalService.create({
      nzTitle:"Editar Tarefa",
      nzContent: ModalComponent,
      nzData: {
        teste: "teste"
      },
      nzOkText: "Ok",
      nzCancelText: "Cancelar",
      nzClosable: true,
      nzOnCancel: () => {
        this.getTarefas();
      },
      nzOnOk: () => {
        this.getTarefas();
      }
    });
  }

  abrirModalCadastrar() {
    this.modalService.create({
      nzTitle:"Cadastrar Tarefa",
      nzContent: ModalCadastroComponent,
      nzOkText: "Ok",
      nzCancelText: "Cancelar",
      nzClosable: true,
      nzOnCancel: () => {
        this.getTarefas();
      },
      nzOnOk: () => {
        this.getTarefas();
      }
    });
  }


  ngOnInit(): void {
    this.getTarefas();
    this.getUsuarios();

  }

getUsuarios() {
    this.usuariosService.getUsuarios().subscribe((data) => {
      this.usuarios = data;
      console.log(this.usuarios);
    });
  }


  getTarefas() {
    this.tarefasService.getTarefas().subscribe((data) => {
      this.tarefas = data;
      console.log(this.tarefas);
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


  removerTarefa(id: number) {
    this.tarefasService.removerTarefa(id).subscribe(
      (resultado: any) => {
        this.getTarefas(); 
        if (resultado.message === 'Tarefa deletada com sucesso') {
          this.mostrarMensagem('success', 'Excluída!', 'A tarefa foi excluída com sucesso');
        } else {
          this.mostrarMensagem('error', 'Erro!', 'Ocorreu um erro ao excluir a tarefa');
        }
      }
    );
  }

  marcarComoConcluida(id: number) {
    this.tarefasService.marcarComoConcluida(id).subscribe(
      (resultado: any) => {
        this.getTarefas(); 
        if (resultado.message === 'Tarefa marcada como concluida') {
          this.mostrarMensagem('success', 'Atualizada!', 'A tarefa foi atualizada com sucesso');
        } else {
          this.mostrarMensagem('error', 'Erro!', 'Ocorreu um erro ao atualizar a tarefa');
        }
      }
    );
  }


  getTarefasFiltro(id: string, titulo: string, descricao: string, situacao: string, responsavel: string) {
    
    this.tarefasService.getTarefasFiltro(id, titulo, descricao, situacao, responsavel).subscribe(
      (result) => {
      
        this.tarefas = result;
        console.log(this.tarefas);
      },
      (error) => {
      
        console.error('Erro ao pesquisar tarefas:', error);
      }
    );

  }

}