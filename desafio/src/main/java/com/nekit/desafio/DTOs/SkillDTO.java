package com.nekit.desafio.DTOs;

import com.nekit.desafio.entities.Skill;

public class SkillDTO {
	
	private int idSkill;
	private String name;
	private String version;
	private String description;
	private String imageUrl;
	
// ---- CONSTRUCTOR'S
	//--Default	
	public SkillDTO() {
		
	}

	//--Full from Class
	public SkillDTO(Skill skill) {
		super();
		this.idSkill = skill.getIdSkill();
		this.name = skill.getName();
		this.version = skill.getVersion();
		this.description = skill.getDescription();
		this.imageUrl = skill.getImageUrl();
	}

// ----------------- GETTER'S - NO SETTER'S -------------------------
	public int getIdSkill() {
		return idSkill;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "SkillDTO [idSkill=" + idSkill + ", name=" + name + ", version=" + version + ", description="
				+ description + ", imageUrl=" + imageUrl + "]";
	}
	
}
