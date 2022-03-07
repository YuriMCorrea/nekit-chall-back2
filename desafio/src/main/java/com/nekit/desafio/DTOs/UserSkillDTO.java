package com.nekit.desafio.DTOs;

import java.time.LocalDateTime;

import com.nekit.desafio.entities.UserSkill;

public class UserSkillDTO {
	
	private int idUserSkill;
	private int idUser;
	private int idSkill;
	private int knowledgeLevel;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
// ---- CONSTRUCTOR'S
	//--Default	
	public UserSkillDTO() {
		
	}
	//--Full from Class
	public UserSkillDTO(UserSkill userSkill) {
		super();
		this.idUserSkill = userSkill.getIdUserSkill();
		this.idUser = userSkill.getUser().getIdUser();
		this.idSkill = userSkill.getSkill().getIdSkill();
		this.knowledgeLevel = userSkill.getKnowledgeLevel();
		this.createdAt = userSkill.getCreatedAt();
		this.updatedAt = userSkill.getUpdatedAt();
	}
	
// ----------------- GETTER'S - NO SETTER'S -------------------------
	public int getIdUserSkill() {
		return idUserSkill;
	}
	public int getIdUser() {
		return idUser;
	}
	public int getIdSkill() {
		return idSkill;
	}
	public int getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "UserSkillDTO [idUserSkill=" + idUserSkill + ", idUser=" + idUser + ", idSkill=" + idSkill
				+ ", knowledgeLevel=" + knowledgeLevel + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
