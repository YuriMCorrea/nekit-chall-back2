package com.nekit.desafio.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {
	
	@NotEmpty(message = "Todo Usuário deve possuir um Login.")
	@Size(max = 12, message = "Nome da Skill deve possuir no máximo 12 caracteres.")
	private String login;
	
	@NotEmpty(message = "Todo Usuário deve possuir uma Senha.")
	@Size(max = 100, message = "Nome da Skill deve possuir no máximo 100 caracteres.")
	private String password;

// ---- CONSTRUCTOR'S
	//--Default	
	public UserForm() {
	}
	//--Full
	public UserForm(
			@NotEmpty(message = "Todo Usuário deve possuir um Login.") @Size(max = 12, message = "Nome da Skill deve possuir no máximo 12 caracteres.") String login,
			@NotEmpty(message = "Todo Usuário deve possuir uma Senha.") @Size(max = 100, message = "Nome da Skill deve possuir no máximo 100 caracteres.") String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
// ----------------- GETTER'S & SETTER'S -------------------------
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
// ----------------- TO STRING -------------------------	
	@Override
	public String toString() {
		return "UserForm [login=" + login + ", password=" + password + "]";
	}

}
