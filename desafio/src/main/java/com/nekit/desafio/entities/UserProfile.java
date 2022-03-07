package com.nekit.desafio.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class UserProfile implements Serializable, GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUserProfile;
	private String profileName;
	
// ---- CONSTRUCTOR'S
	//--Default
	public UserProfile() {
		
	}
	//--Full
	public UserProfile(Integer idUserProfile, String profileName) {
		super();
		this.idUserProfile = idUserProfile;
		this.profileName = profileName;
	}
	
// ----------------- GETTER'S & SETTER'S -------------------------
	public Integer getIdUserProfile() {
		return idUserProfile;
	}
	public void setIdUserProfile(Integer idUserProfile) {
		this.idUserProfile = idUserProfile;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
// ----------------- HASH CODE -------------------------
	@Override
	public int hashCode() {
		return Objects.hash(idUserProfile, profileName);
	}
	
// ----------------- EQUALS -------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(idUserProfile, other.idUserProfile) && Objects.equals(profileName, other.profileName);
	}

// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "UserProfile [idUserProfile=" + idUserProfile + ", profileName=" + profileName + "]";
	}
	
// ----------------- CONFIGURAÇÃO GRANTED AUTHORITY -------------------------
	@Override
	public String getAuthority() {
		return profileName;
	}

}
