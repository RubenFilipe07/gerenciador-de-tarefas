import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class TarefasService  {

  
  constructor(private http: HttpClient, private authService: AuthService) { }

  

  private apiUrl = 'http://gerenciador-de-tarefas-production.up.railway.app/api/tarefas';


  private id: string = "";
  private titulo: string = "";
  private descricao: string = "";
  private situacao: string = "";
  private responsavel: string = "";

  public setId(id: string): void {
    this.id = id;
  }

  public getId(): string {
    return this.id;
  }

  public setTitulo(titulo: string): void {
    this.titulo = titulo;
  }

  public getTitulo(): string {
    return this.titulo;
  }

  public setDescricao(descricao: string): void {
    this.descricao = descricao;
  }

  public getDescricao(): string {
    return this.descricao;
  }

  public setSituacao(situacao: string): void {
    this.situacao = situacao;
  }

  public getSituacao(): string {
    return this.situacao;
  }

  public setResponsavel(responsavel: string): void {
    this.responsavel = responsavel;
  }

  public getResponsavel(): string {
    return this.responsavel;
  }

  public getTarefas(): Observable<any> {
    const token = this.authService.getToken(); 
    const headers = new HttpHeaders({
      'Authorization': `${token}`
    });

    return this.http.get(this.apiUrl, { headers, responseType: 'json' });
  }

  public removerTarefa(id: number): Observable<any> {
    return this.http.delete(this.apiUrl + '/' + id, {responseType: 'json' })
  }

  public marcarComoConcluida(id: number): Observable<any> {
    return this.http.put(this.apiUrl + '/' + id + '/concluida', {  responseType: 'json' })
  }

  public atualizarTarefa(id: string | null, titulo: string | null, descricao: string| null, situacao: string| null, responsavel: string | null): Observable<any> {

    const token = this.authService.getToken(); 
    const headers = new HttpHeaders({
      'Authorization': `${token}`
    });

    id = id === "" ? null : id;
    titulo = titulo === "" ? null : titulo;
    descricao = descricao === "" ? null : descricao;
    situacao = situacao === "" ? null : situacao;
    responsavel = responsavel === "" ? null : responsavel;

    return this.http.put(this.apiUrl + '/' + id, { titulo, descricao, situacao, responsavel },  { headers, responseType: 'json' });
  }

  public cadastrarTarefa(titulo: string, descricao: string, situacao: string, prioridade: string, responsavel: string, deadline: string): Observable<any> {

    const token = this.authService.getToken(); 
    const headers = new HttpHeaders({
      'Authorization': `${token}`
    });

    console.log(this.apiUrl, { titulo, descricao, situacao, prioridade, responsavel, deadline })
    return this.http.post(this.apiUrl, { titulo, descricao, situacao, prioridade, responsavel, deadline }, { headers, responseType: 'json' });
   
  }

  private apiUrlFiltro = 'http://gerenciador-de-tarefas-production.up.railway.app/tarefas/filtro?';


  public getTarefasFiltro(
    id: string,
    titulo: string,
    descricao: string,
    situacao: string,
    responsavel: string
  ): Observable<any> {


    const token = this.authService.getToken(); 
    const headers = new HttpHeaders({
      'Authorization': `${token}`
    });


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

    console.log(this.apiUrlFiltro, { headers, responseType: 'json' })

    return this.http.get(this.apiUrlFiltro+ params, { headers, responseType: 'json' });


  }


}