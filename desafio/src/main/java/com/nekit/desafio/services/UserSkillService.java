package com.nekit.desafio.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nekit.desafio.DTOs.UserSkillDTO;
import com.nekit.desafio.entities.Skill;
import com.nekit.desafio.entities.User;
import com.nekit.desafio.entities.UserSkill;
import com.nekit.desafio.forms.UserSkillForm;
import com.nekit.desafio.repositories.SkillRepository;
import com.nekit.desafio.repositories.UserRepository;
import com.nekit.desafio.repositories.UserSkillRepository;

@Service
public class UserSkillService {
	
	@Autowired
	private UserSkillRepository userSkillRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SkillRepository skillRepository;	

// - - - - - - - GET ALL "UserSkill" - - - - - - - 
		public Page<UserSkill> findAll(Pageable paginacao) {
			return userSkillRepository.findAll(paginacao);
		}
		
// - - - - - - - GET "UserSkill" BY ID - - - - - - -
	public ResponseEntity<UserSkillDTO> findById(Integer id) {
		Optional<UserSkill> obj = userSkillRepository.findById(id);
		if(obj.isPresent()) {
			return ResponseEntity.ok(new UserSkillDTO(obj.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
// - - - - - - - GET "UserSkill" BY "User" ID - - - - - - -
	public Page<UserSkill> findByUserId(Pageable paginacao, Integer idUser) {
		
		User user = userRepository.getById(idUser);
			
		return userSkillRepository.findByUser(user, paginacao);
		
		
	}
	
// - - - - - - - CREATE "UserSkill"  - - - - - - -	
	public UserSkill insert(UserSkill obj) {
		obj = userSkillRepository.save(obj);
		return obj;
	}
	
// - - - - - - - UPDATE "UserSkill"  - - - - - - -
	public ResponseEntity<UserSkillDTO> update(UserSkill obj, Integer idUserSkill) {
		Optional<UserSkill> userSkill = userSkillRepository.findById(idUserSkill);
		if(userSkill.isPresent()) {
			userSkill.get().setKnowledgeLevel(obj.getKnowledgeLevel());
			userSkill.get().setUpdatedAt(LocalDateTime.now());
			return ResponseEntity.ok(new UserSkillDTO(userSkill.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
// - - - - - - - DELETE "UserSkill" - - - - - - -
	public ResponseEntity<?> delete(Integer idUserSkill) {
		Optional<UserSkill> userSkill = userSkillRepository.findById(idUserSkill);
		if(userSkill.isPresent()) {
			userSkillRepository.delete(userSkill.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
// - - - - - - - - - - - - - - - - CONVERTIONS - - - - - - - - - - - - - - - - - -
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
// - - - - - - - CLASS TO DTO with PAGES - - - - - - -	
	public Page<UserSkillDTO>  convertObjToDTOwPages(Page<UserSkill> usersSkills) {
		return usersSkills.map(UserSkillDTO::new);
	}
	
// - - - - - - - FORM TO CLASS - - - - - - -
	public UserSkill convertFormToClass(UserSkillForm userSkillForm) {
		User user = userRepository.getById(userSkillForm.getIdUser());
		
		if(user != null) {
			Skill skill = skillRepository.getById(userSkillForm.getIdSkill());
			if (skill != null) {
				return new UserSkill(userSkillForm, user, skill);
			}
		}
		return new UserSkill();
	}
}
