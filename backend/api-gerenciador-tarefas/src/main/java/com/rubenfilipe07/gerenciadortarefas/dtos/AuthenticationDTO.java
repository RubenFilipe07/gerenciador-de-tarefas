package com.rubenfilipe07.gerenciadortarefas.dtos;

import com.rubenfilipe07.gerenciadortarefas.enums.UsuarioRole;

public class AuthenticationDTO{
	
	private String nome;
    private String email;
    private String senha;
    private UsuarioRole role;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioRole getRole() {
		return role;
	}
	public void setRole(UsuarioRole role) {
		this.role = role;
	}
    



}
