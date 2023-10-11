import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrincipalComponent } from './pages/principal/principal.component';
import { LoginComponent } from './pages/login/login.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { TarefasComponent } from './pages/tarefas/tarefas.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { pt_BR } from 'ng-zorro-antd/i18n'; 
import { registerLocaleData } from '@angular/common';
import ptBr from '@angular/common/locales/pt';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

registerLocaleData(ptBr);

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent,
    LoginComponent,
    CadastroComponent,
    TarefasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [
    { provide: NZ_I18N, useValue: pt_BR }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }