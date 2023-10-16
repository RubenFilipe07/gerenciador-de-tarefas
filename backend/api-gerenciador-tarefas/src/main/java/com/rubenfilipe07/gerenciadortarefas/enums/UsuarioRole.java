package com.rubenfilipe07.gerenciadortarefas.enums;

public enum UsuarioRole {
	
	ADMIN("admin"),
	USER("user");
	
	private String role;
	
	UsuarioRole(String string) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



}
