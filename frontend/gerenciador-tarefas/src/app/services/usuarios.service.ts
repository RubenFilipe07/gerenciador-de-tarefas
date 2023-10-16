import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Usuario } from '../models/usuario.model';
import { Login } from '../models/login.model';
import { AuthService } from './auth.service';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private apiUrl = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient, private authService: AuthService) { }

  public getUsuarios(): Observable<any> {
    const token = this.authService.getToken(); 
    const headers = new HttpHeaders({
      'Authorization': `${token}`
    });

    return this.http.get(this.apiUrl, { headers, responseType: 'json' });
  }

  private apiUrlAuth = 'http://localhost:8080/auth/cadastro';

  public cadastrarUsuario(usuario: Usuario): Observable<any> {
  
    const data = {
      "nome": usuario.nome,
      "email": usuario.email,
      "senha": usuario.senha,
      "role": usuario.role
    }
    return this.http.post(this.apiUrlAuth, data); 
  }

  private apiUrlLogin = 'http://localhost:8080/auth/login';

  public loginUsuario(usuario: Login): Observable<any> {
    const data = {
      "email": usuario.email,
      "senha": usuario.senha
    }

    return this.http.post(this.apiUrlLogin, data).pipe(
    
      tap((response: any) => {
        const token = response.token; 
        if (token) {
          this.authService.setToken(token);
        }
      })
    );
  }

}
