package com.nekit.desafio.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nekit.desafio.DTOs.SkillDTO;
import com.nekit.desafio.entities.Skill;
import com.nekit.desafio.forms.SkillForm;
import com.nekit.desafio.repositories.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
// - - - - - - - GET ALL "Skill" - - - - - - - 
	public Page<Skill> findAll(Pageable paginacao) {
		return skillRepository.findAll(paginacao);
	}
	
// - - - - - - - GET "Skill" BY ID - - - - - - -
	public ResponseEntity<SkillDTO> findById(Integer id) {
		Optional<Skill> obj = skillRepository.findById(id);
		if(obj.isPresent()) {
			return ResponseEntity.ok(new SkillDTO(obj.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
// - - - - - - - CREATE "Skill"  - - - - - - -
	public Skill insert(Skill obj) {
		obj = skillRepository.save(obj);
		return obj;
	}
	
// - - - - - - - UPDATE "Skill"  - - - - - - -
	public ResponseEntity<SkillDTO> update(Skill obj, Integer id) {
		Optional<Skill> skill = skillRepository.findById(id);
		if(skill.isPresent()) {
			skill.get().setName(obj.getName());
			skill.get().setVersion(obj.getVersion());
			skill.get().setDescription(obj.getDescription());
			skill.get().setImageUrl(obj.getImageUrl());
			return ResponseEntity.ok(new SkillDTO(skill.get()));
		}
		return ResponseEntity.notFound().build();
		
	}

// - - - - - - - DELETE "Skill" - - - - - - -
	public ResponseEntity<?> delete(Integer id) {
		Optional<Skill> skill = skillRepository.findById(id);
		if(skill.isPresent()) {
			skillRepository.delete(skill.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
// - - - - - - - - - - - - - - - - CONVERTIONS - - - - - - - - - - - - - 
	
// - - - - - - - CLASS TO DTO with PAGES - - - - - - -	
	public Page<SkillDTO>  convertObjToDTOwPages(Page<Skill> skills) {
		return skills.map(SkillDTO::new);
	}
	
// - - - - - - - FORM TO CLASS - - - - - - -
	public Skill convertFormToClass(SkillForm skillForm) {
		return new Skill(skillForm);
	}
	
}
