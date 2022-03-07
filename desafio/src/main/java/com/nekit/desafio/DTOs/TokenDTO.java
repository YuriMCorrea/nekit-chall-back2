package com.nekit.desafio.DTOs;

public class TokenDTO {
	
	private String token;
	private String tipo;
	
// ---- CONSTRUCTOR'S
	//--Default
	public TokenDTO() {
		
	}
	//--Full
	public TokenDTO(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}
	
// ----------------- GETTER'S & SETTER'S -------------------------
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "TokenDTO [token=" + token + ", tipo=" + tipo + "]";
	}
	
}
