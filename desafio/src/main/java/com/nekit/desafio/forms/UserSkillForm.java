package com.nekit.desafio.forms;

import javax.validation.constraints.NotNull;

public class UserSkillForm {
	
	@NotNull(message = "Campo id do usuário é obrigatório")
	private int idUser;
	@NotNull(message = "Campo id do skill é obrigatório")
	private int idSkill;
	@NotNull(message = "Campo nível de conhecimento é obrigatório")
	private Integer knowledgeLevel;
	
// ---- CONSTRUCTOR'S
	//--Default	
	public UserSkillForm() {
	}
	//--Full
	public UserSkillForm(@NotNull(message = "Campo id do usuário é obrigatório") int idUser,
			@NotNull(message = "Campo id do skill é obrigatório") int idSkill,
			@NotNull(message = "Campo nível de conhecimento é obrigatório") Integer knowledgeLevel) {
		super();
		this.idUser = idUser;
		this.idSkill = idSkill;
		this.knowledgeLevel = knowledgeLevel;
	}
// ----------------- GETTER'S & SETTER'S -------------------------
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}
	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "UserSkillForm [idUser=" + idUser + ", idSkill=" + idSkill + ", knowledgeLevel=" + knowledgeLevel + "]";
	}
	
}
