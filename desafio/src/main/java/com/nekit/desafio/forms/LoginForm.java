package com.nekit.desafio.forms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginForm {
	
	private String login;
	private String senha;
	
	
// ---- CONSTRUCTOR'S
	//--Default	
	public LoginForm() {
	}
	//--Full
	public LoginForm(String login, String senha) {
		super();
		this.login = login;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}
	
// ----------------- GETTER'S & SETTER'S -------------------------
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "LoginForm [login=" + login + ", senha=" + senha + "]";
	}
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.login, this.senha);
	}
	
}
