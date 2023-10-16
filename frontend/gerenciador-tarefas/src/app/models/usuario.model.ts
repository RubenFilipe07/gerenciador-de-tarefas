export class Usuario {

    nome: string;
    email: string;
    senha: string;
    role: string;

    constructor(nome: string, email: string, senha: string, role: string) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}