import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  private apiUrl = 'http://localhost:8080/api/tarefas';

  constructor(private http: HttpClient) { }


  public getTarefas(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  public removerTarefa(id: number): Observable<any> {
    return this.http.delete(this.apiUrl + '/' + id, { responseType: 'json' })
  }

  public marcarComoConcluida(id: number): Observable<any> {
    return this.http.put(this.apiUrl + '/' + id + '/concluida', { responseType: 'json' })
  }

  public atualizarTarefa(id: string | null, titulo: string | null, descricao: string| null, situacao: string| null, responsavel: string | null): Observable<any> {

    id = id === "" ? null : id;
    titulo = titulo === "" ? null : titulo;
    descricao = descricao === "" ? null : descricao;
    situacao = situacao === "" ? null : situacao;
    responsavel = responsavel === "" ? null : responsavel;

    console.log(this.apiUrl + '/' + id, { titulo, descricao, situacao, responsavel })
    return this.http.put(this.apiUrl + '/' + id, { titulo, descricao, situacao, responsavel }, { responseType: 'json' })
  }

  public cadastrarTarefa(titulo: string, descricao: string, situacao: string, prioridade: string, responsavel: string, deadline: string): Observable<any> {
    return this.http.post(this.apiUrl, { titulo, descricao, situacao, prioridade, responsavel, deadline }, { responseType: 'json' })
  }

  private apiUrlFiltro = 'http://localhost:8080/api/tarefas/filtro?';


  public getTarefasFiltro(
    id: string,
    titulo: string,
    descricao: string,
    situacao: string,
    responsavel: string
  ): Observable<any> {

    let params = new HttpParams();
    if (id !== "") {
      params = params.set('id', id.toString());
    }
    if (titulo !== "") {
      params = params.set('titulo', titulo);
    }
    if (descricao !== "") {
      params = params.set('descricao', descricao);
    }
    if (situacao !== "") {
      params = params.set('situacao', situacao);
    }
    if (responsavel !== "") {
      params = params.set('responsavel', responsavel);
    }

    console.log(this.apiUrlFiltro + params);
    return this.http.get(this.apiUrlFiltro, { params });


  }


}