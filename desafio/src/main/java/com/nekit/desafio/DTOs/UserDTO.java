package com.nekit.desafio.DTOs;

import java.time.LocalDateTime;

import com.nekit.desafio.entities.User;

public class UserDTO {
	
	private Integer idUser;
	private String login;
	private String password;
	private LocalDateTime lastLoginDate;
	
// ---- CONSTRUCTOR'S
	//--Default	
	public UserDTO() {
		
	}
	//--Full from Class
	public UserDTO(User user) {
		super();
		this.idUser = user.getIdUser();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.lastLoginDate = user.getLastLoginDate();
	}
	
// ----------------- GETTER'S - NO SETTER'S -------------------------
	public Integer getIdUser() {
		return idUser;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "UserDTO [idUser=" + idUser + ", login=" + login + ", password=" + password + ", lastLoginDate="
				+ lastLoginDate + "]";
	}
	
}
