package com.nekit.desafio.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nekit.desafio.forms.UserSkillForm;

@Entity
public class UserSkill implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user_skill", nullable=false)
	private Integer idUserSkill;
	
	@JsonIgnore
	@Embedded
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@JsonIgnore
	@Embedded
	@ManyToOne
	@JoinColumn(name = "id_skill")
	private Skill skill;
	
	@Column(name="knowledge_level", nullable=false)
	@Min(value=1)
	@Max(value=10)
	private Integer knowledgeLevel;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at", nullable=true)
	private LocalDateTime updatedAt;
	
// ---- CONSTRUCTOR'S
	//--Default
	public UserSkill() {
		
	}
	//--Full
	public UserSkill(User user, Skill skill, Integer knowledgeLevel, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.user = user;
		this.skill = skill;
		this.knowledgeLevel = knowledgeLevel;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = updatedAt;
	}
	//--Form New "User Skill"
	public UserSkill(UserSkillForm userSkillForm, User user, Skill skill) {
		super();
		this.user = user;
		this.skill = skill;
		this.knowledgeLevel = userSkillForm.getKnowledgeLevel();
		this.createdAt = LocalDateTime.now();
	}
	
// ----------------- GETTER'S & SETTER'S -------------------------
	public Integer getIdUserSkill() {
		return idUserSkill;
	}
	public void setIdUserSkill(Integer idUserSkill) {
		this.idUserSkill = idUserSkill;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
// ----------------- HASH CODE -------------------------
	@Override
	public int hashCode() {
		return Objects.hash(createdAt, idUserSkill, knowledgeLevel, skill, updatedAt, user);
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
		UserSkill other = (UserSkill) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(idUserSkill, other.idUserSkill)
				&& Objects.equals(knowledgeLevel, other.knowledgeLevel) && Objects.equals(skill, other.skill)
				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(user, other.user);
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "UserSkill [idUserSkill=" + idUserSkill + ", user=" + user + ", skill=" + skill + ", knowledgeLevel="
				+ knowledgeLevel + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}	
	
}
