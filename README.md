# Gerenciador de tarefas | SIGTarefas

Uma gerenciador de tarefas desenvolvido para o teste técnico da esig group. Feito com Angular e Spring, que tem como objetivo organizar as tarefas em de uma equipe. Foi utilizado um sistema de login feito com Spring security e tokens JWT.

## Requisitos
-   Node.js: Versão 16 ou superior
-   Java: Versão 11
-   Angular: Versão 16.2.0
-   PostgreSQL: Um banco de dados PostgreSQL

## Orientações de execução

<h5>Para rodar o projeto Angular</h5>
<ol>
  <li>Certifique-se de ter o node.js instalado na sua máquina, caso não tenha, baixe aqui: <a href="https://nodejs.org/en/">nodejs.org</a></li>
  <li>Dentro do projeto digite <code>npm i</code> no terminal para baixar as dependências</li>
  <li>Digite <code>ng serve</code> para iniciar o servidor e o acesse pelo link: <code>http://localhost:4200/</code></li>
</ol>

<h5>Para rodar o projeto Spring</h5>
<ol>
  <li>Com um servidor postgresql rodando em sua máquina, veja as configurações de conexão com o banco de dados em  <code>src/main/resources/application.properties</code> para realizar a conexão de acordo com suas credenciais locais. Valores utilizados</li>
  <code>spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.datasource.url= jdbc:postgresql://localhost:5432/gerenciadorTarefas
spring.datasource.username=postgres
spring.datasource.password=123
spring.jpa.hibernate.ddl-auto=update
spring.mvc.pathmatch.matching-strategy=ant-path-matcher
api.security.token.secret=${JWT_SECRET_SEC_TOKEN}</code>
  <li>Crie uma variável de ambiente para JWT_SECRET_SEC_TOKEN</li>
  <li>Crie um banco com o nome criado na instrução anterior</li>
  <li>Inicie um servidor local do projeto com <code>/mvnw spring-boot:run</code></li>
    <li>Ou utilize sua IDE de preferência</code></li>

  <li>Feito isso, a aplicação irá rodar em: <code>http://localhost:8080/</code></li>
</ol>


## Links

<h3>Links (Servidor)</h3>
<ul>
    <li><a  href="https://gerenciador-de-tarefas-production.up.railway.app/swagger-ui/index.html">Docs -> https://gerenciador-de-tarefas-production.up.railway.app/swagger-ui/index.html</a></li>
    <li><a  href="https://sigtarefas.web.app/">  Aplicação  -> https://sigtarefas.web.app/</a></li>
    <li><a  href="https://gerenciador-de-tarefas-production.up.railway.app/">API -> https://gerenciador-de-tarefas-production.up.railway.app/</a></li>  
</ul>

<h3>Links (Localhost)</h3>
<ul>
    <li><a href="http://localhost:4200/">Aplicação -> http://localhost:4200/</a></li>
    <li><a href="http://localhost:8080/swagger-ui/index.html">Docs -> http://localhost:8080/swagger-ui/index.html</a></li>
</ul>

## Endpoints

http://localhost:8080/api/tarefas </br>
http://localhost:8080/api/cadastro </br>
http://localhost:8080/auth/login </br>
http://localhost:8080/auth/cadastro </br>

## Itens feitos 

- **Front-end com Angular** (v16.20.0)
- **Back-end Java 11 e Spring Boot** (Java 11, Spring 2.7.1)
- **Endpoints REST** implementados
- **Autenticação JWT** implementada
- **Banco de dados PostgreSQL e JPA** utilizados
- **Testes unitários** com JUnit 5 e Mockito para classes de serviço
- **Swagger UI** implementado
- **Hospedagem:** Back-end rodando no Railway.app e front-end no Firebase


<h3>Front-end</h3>


 <a href="https://angular.io/">
    <img src="https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white" />
  </a> <br/>
 <a href="https://www.typescriptlang.org/">
    <img src="https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white" />
  </a> <br/>
  
 <a href="https://rxjs.dev/">
    <img src="https://img.shields.io/badge/RXJS-B7178C?style=for-the-badge&logo=ReactiveX&logoColor=white" />
  </a> <br/>
  
 <a href="https://ng.ant.design/docs/introduce/en">
    <img src="https://img.shields.io/badge/Ng%20zorro%20(Ant design)-007DB8?style=for-the-badge&logo=antdesign&logoColor=white" />
  </a> <br/>
  
  <a href="https://ng.ant.design/components/icon/en">
    <img src="https://img.shields.io/badge/ng%20zorro%20Icons-007DB8?style=for-the-badge&logo=antdesign&logoColor=white" />
  </a> <br/>
  
 <h3>Back-end</h3>

  <a href="https://swagger.io">
    <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white"/>
  </a> <br/>
  
  <a href="https://spring.io/projects/spring-boot">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
  </a> <br/>

  <a href="https://spring.io/projects/spring-security">
  <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
  </a>  <br/>

  <a href="https://jwt.io/">
  <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON Web Tokens&logoColor=white" />
</a>  <br/>

<a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS">
  <img src="https://img.shields.io/badge/CORS-FF8800?style=for-the-badge&logo=corslogoColor=white" />
</a>  <br/>

  
  <a href="https://www.java.com/">
  <img src="https://img.shields.io/badge/Java-e61e2c?style=for-the-badge&logo=openjdk&logoColor=white" />
  </a> <br/>

  <a href="https://junit.org/junit5/">
  <img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white" />
  </a> <br/>
  
 <h3>Banco de dados</h3>
 
  <a href="https://www.postgresql.org/">
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
  </a> <br/>

## Hospedagem
 
  <a href="https://firebase.google.com/">
    <img src="https://img.shields.io/badge/firebase-ffca28?style=for-the-badge&logo=firebase&logoColor=black" />
  </a> <br/>
  
  <a href="https://railway.app/">
    <img src="https://img.shields.io/badge/Railway-0B0D0E?style=for-the-badge&logo=railway&logoColor=white" />
  </a> <br/>

 ## Licensa

<a href="https://github.com/RubenFilipe07/gerenciador-de-tarefas/blob/main/LICENSE">MIT</a>



 
