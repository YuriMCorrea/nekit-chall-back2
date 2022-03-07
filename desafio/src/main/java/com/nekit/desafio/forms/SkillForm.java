package com.nekit.desafio.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SkillForm {
	
	@NotEmpty(message = "Todo Skill deve possuir um Nome.")
	@Size(max = 100, message = "Nome da Skill deve possuir no máximo 100 caracteres.")
	private String name;
	
	@Size(max = 10, message = "Version da Skill deve possuir no máximo 10 caracteres.")
	private String version;
	
	@NotEmpty(message = "Todo Skill deve possuir uma Descrição.")
	@Size(max = 255, message = "Descrição da Skill deve possuir no máximo 255 caracteres.")
	private String description;
	
	@Size(max = 255, message = "URL da imagem da Skill deve possuir no máximo 255 caracteres.")
	private String imageUrl;
	
// ---- CONSTRUCTOR'S
	//--Default	
	public SkillForm() {
	}
	//--Full
	public SkillForm(
			@NotEmpty(message = "Todo Skill deve possuir um Nome.") @Size(max = 100, message = "Nome da Skill deve possuir no máximo 100 caracteres.") String name,
			@Size(max = 10, message = "Version da Skill deve possuir no máximo 10 caracteres.") String version,
			@NotEmpty(message = "Todo Skill deve possuir uma Descrição.") @Size(max = 255, message = "Descrição da Skill deve possuir no máximo 255 caracteres.") String description,
			@Size(max = 255, message = "URL da imagem da Skill deve possuir no máximo 255 caracteres.") String imageUrl) {
		super();
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
// ----------------- GETTER'S & SETTER'S -------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "SkillForm [name=" + name + ", version=" + version + ", description=" + description + ", imageUrl="
				+ imageUrl + "]";
	}
	
}
