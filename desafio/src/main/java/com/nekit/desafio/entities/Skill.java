package com.nekit.desafio.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nekit.desafio.forms.SkillForm;

@Entity
@Embeddable
public class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_skill", nullable=false)
	private Integer idSkill;
	@Column(name="name_skill", nullable=false, length=100)
	private String name;
	@Column(name="version_skill", nullable=true, length=10)
	private String version;
	@Column(name="description_skill", nullable=false, length=255)
	private String description;
	@Column(name="image_skill", nullable=true, length=255)
	private String imageUrl;
	
// ---- CONSTRUCTOR'S
	//--Default
	public Skill() {
		
	}
	//--Full
	public Skill(Integer idSkill, String name, String version, String description, String imageUrl) {
		super();
		this.idSkill = idSkill;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	//--Form
	public Skill(SkillForm skillForm) {
		this.name = skillForm.getName();
		this.version = skillForm.getVersion();
		this.description = skillForm.getDescription();
		this.imageUrl = skillForm.getImageUrl();
	}

// ----------------- GETTER'S & SETTER'S -------------------------
	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

// ----------------- HASH CODE -------------------------
	@Override
	public int hashCode() {
		return Objects.hash(description, idSkill, imageUrl, name, version);
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
		Skill other = (Skill) obj;
		return Objects.equals(description, other.description) && Objects.equals(idSkill, other.idSkill)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Objects.equals(version, other.version);
	}

// ----------------- TO STRING -------------------------
	@Override
	public String toString() {
		return "Skill [idSkill=" + idSkill + ", name=" + name + ", version=" + version + ", description=" + description
				+ ", imageUrl=" + imageUrl + "]";
	}

	
	
}
