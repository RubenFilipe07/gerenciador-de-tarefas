# Gerenciador de Tarefas | SIGTarefas

<p align="center">
  <a href="https://sigtarefas.web.app/">
    <img src="https://github.com/RubenFilipe07/detector-ofensas/assets/53026536/0f7d2f29-1daa-4131-aabe-564f828cebc4" />
  </a>
</p>

<p>
Uma gerenciador de tarefas desenvolvido para o teste técnico da ESIG Group. O sistema tem como objetivo gerenciar as tarefas de uma equipe, com a capacidade de as delegar a diferentes usuários cadastrados e fornecer as ferramentas necessárias para mantê-las, como as funcionalidades de criação, remoção, conclusão, edição e pesquisa de uma determinada tarefa.
Implementado com Angular e Spring, o sistema trata-se de um site uma API REST, em que foi utilizado um sistema de login feito com spring security e tokens JWT, além de bloquear requisições não autenticadas, para aprimorar a segurança e privacidade dos dados, bem como foi utilizado rotas privadas na aplicação que dependem de autenticação para serem exibidas.
</p>

## Requisitos
-   Node.js: Versão 16 ou superior (Requerida pelo angular 16)
-   Java: Versão 11
-   Angular: Versão 16.2.0
-   PostgreSQL: Um banco de dados PostgreSQL

## Orientações de execução

<ol>
  <li>Clone o repositório com o comando: <code>git clone https://github.com/RubenFilipe07/gerenciador-de-tarefas.git</code> </li>
</ol>


<h5>Para rodar o projeto Angular</h5>
<ol>
  <li>Certifique-se de ter o node.js instalado na sua máquina, caso não tenha, baixe aqui: <a href="https://nodejs.org/en/">nodejs.org</a></li>
  <li>Caso o Angular CLI não estiver instalado, você pode instalá-lo usando o seguinte comando:</li> <code>npm install -g @angular/cli</code>
  <li>Dentro do projeto digite <code>npm i</code> no terminal para baixar as dependências do projeto</li>
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
  <li>Crie um banco com o nome criado na instrução anterior</li>
  <li>Crie uma variável de ambiente para JWT_SECRET_SEC_TOKEN</li>
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
    <li><a href="http://localhost:8080/swagger-ui/index.html">Docs -> http://localhost:8080/swagger-ui/index.html</a></li>
    <li><a href="http://localhost:4200/">Aplicação -> http://localhost:4200/</a></li>
    <li><a href="http://localhost:8088">API -> http://localhost:8080</a></li>
</ul>

## Endpoints

Alguns endpoints exigem autenticação por JWT, são eles: GET "/api/tarefas" e GET "/api/usuarios". POST "/api/tarefas" necessita de um 'role' (função/papel atribuido) de ADMIN ou USER. <br/>
Para acessá-los, é preciso utilizar na requisição o header: <code>'Authorization': `${token}`}</code> <br/> 

Key: <code>Authorization</code> <br/>
Value: <code>${token gerado ao fazer login}</code> <br/> 
Tal como na imagem abaixo: 

![image](https://github.com/RubenFilipe07/gerenciador-de-tarefas/assets/53026536/8dc70a1a-b0d6-4571-99c2-be6bf2d28469)


Visualize com: </br>
<a href="https://www.postman.com">
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/>
</a> 
</p>


### Tarefas

- **GET /api/tarefas**: Obtém a lista de tarefas.
- **GET /api/tarefas/{id}**: Obtém os detalhes de uma tarefa específica.
- **POST /api/tarefas**: Cria uma nova tarefa.
- **DELETE /api/tarefas/{id}**: Exclui uma tarefa por ID.
- **PUT /api/tarefas/{id}**: Atualiza uma tarefa existente por ID.
- **PUT /api/tarefas/{id}/concluida**: Marca uma tarefa como concluída.

#### Filtrar Tarefas

- **GET /api/tarefas/filtro?**: Filtra as tarefas com base em parâmetros.
  - Parâmetros de consulta:
    - `id`: ID da tarefa (opcional).
    - `titulo`: Título da tarefa (opcional).
    - `descricao`: Descrição da tarefa (opcional).
    - `situacao`: Situação da tarefa (opcional).
    - `responsavel`: Responsável pela tarefa (opcional).

### Usuários

- **GET /api/cadastro**: Obtém a lista de usuários.
- **POST /api/cadastro**: Cria um novo usuário.
- **GET /api/cadastro/{id}**: Obtém os detalhes de um usuário específico.
- **PUT /api/cadastro/{id}**: Atualiza um usuário por ID.
- **DELETE /api/cadastro/{id}**: Exclui um usuário por ID.

### Autenticação

- **POST /auth/login**: Realiza o login do usuário e recebe o JWT Token.
- **POST /auth/cadastro**: Cria um novo cadastro de usuário.

## Itens feitos 

- **Front-end com Angular** (v16.2.0)
- **Back-end Java 11 e Spring Boot** (Java 11, Spring 2.7.1)
- **Endpoints REST** implementados
- **Autenticação JWT** implementada
- **Banco de dados PostgreSQL e JPA** utilizados
- **Testes unitários** com JUnit 5 e Mockito para classes de serviço
- **Swagger UI** implementado
- **Hospedagem** Back-end e banco de dados rodando no Railway.app e front-end no Firebase
-  **Diferenciais:**
     <ol>
        <li>As senhas são devidamente criptografadas, garantindo a segurança das informações dos usuários</li>
        <li>Os endpoints críticos exigem autenticação por meio de JWT TOKEN, que é gerado quando um usuário faz login</li>
        <li>Para a estilização do front-end, foi utilizado o framework ng-zorro</li>
      </ol>

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

## Demonstração 

<img src="https://github.com/RubenFilipe07/gerenciador-de-tarefas/assets/53026536/58078ba9-369d-4994-93a1-47b3efda4056" width="850" />

<img src="https://github.com/RubenFilipe07/gerenciador-de-tarefas/assets/53026536/1118b2b1-43d7-421e-adec-c4e3bd8516b2" width="850" />

<img src="https://github.com/RubenFilipe07/gerenciador-de-tarefas/assets/53026536/05012aaf-1ef7-4eb4-ae99-69bb79f3621f" width="850" />

 ## Licensa

<a href="https://github.com/RubenFilipe07/gerenciador-de-tarefas/blob/main/LICENSE">MIT</a>



 
