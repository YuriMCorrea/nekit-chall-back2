package com.nekit.desafio.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nekit.desafio.DTOs.UserSkillDTO;
import com.nekit.desafio.entities.UserSkill;
import com.nekit.desafio.forms.UserSkillForm;
import com.nekit.desafio.services.UserSkillService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userSkill")
public class UserSkillController {
	
	@Autowired
	private UserSkillService userSkillService; 

// - - - - - - - GET ALL "UserSkill" - - - - - - -
	@GetMapping
	@ApiOperation(value = "Busca todas UserSkills")
	public ResponseEntity<Page<UserSkillDTO>> findAll(@PageableDefault(sort = "idUserSkill", 
	direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Page<UserSkill> usersSkills = userSkillService.findAll(paginacao);
		return ResponseEntity.ok(userSkillService.convertObjToDTOwPages(usersSkills));
	}

// - - - - - - - GET "UserSkill" BY ID - - - - - - -
	@GetMapping("/{idUserSkill}")
	@ApiOperation(value = "Busca UserSkill por ID da UserSkill")
	public ResponseEntity<UserSkillDTO> findById(@PathVariable("idUserSkill") Integer id) {
		return userSkillService.findById(id);
	}
	
// - - - - - - - GET "UserSkill" BY "User" ID - - - - - - -
	@GetMapping("/user/{idUser}")
	@ApiOperation(value = "Busca UserSkill por ID do Usuário")
	public ResponseEntity<Page<UserSkillDTO>> findByUserId(@PageableDefault(sort = "idUserSkill", 
			direction = Direction.DESC, page = 0, size = 10) Pageable paginacao, @PathVariable("idUser") Integer idUser) {
		Page<UserSkill> userSkills = userSkillService.findByUserId(paginacao, idUser);
		return ResponseEntity.ok(userSkillService.convertObjToDTOwPages(userSkills));
	}
	
// - - - - - - - POST "UserSkill" - - - - - - -
	@Transactional
	@PostMapping
	@ApiOperation(value = "Cria nova UserSkill")
	public ResponseEntity<String> insert(@Valid @RequestBody UserSkillForm userSkillForm) {
			
		UserSkill userSkill = userSkillService.convertFormToClass(userSkillForm);
		if(userSkill.getCreatedAt() != null) {
			userSkill = userSkillService.insert(userSkill);
			// Returning URI with code
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSkill.getIdUserSkill()).toUri();
			return ResponseEntity.created(uri).build();
		}
		return ResponseEntity.notFound().build();
	}
	
// - - - - - - - UPDATE "UserSkill"  - - - - - - -
	@Transactional
	@PutMapping("/{idUserSkill}")
	@ApiOperation(value = "Edita UserSkill por ID")
	public ResponseEntity<UserSkillDTO> update(@Validated @RequestBody UserSkillForm userSkillForm, @PathVariable("idUserSkill") Integer idUserSkill) {
		UserSkill userSkill = userSkillService.convertFormToClass(userSkillForm);
		
		return userSkillService.update(userSkill, idUserSkill);
		
	}
	
// - - - - - - - DELETE "UserSkill" - - - - - - -
	@Transactional
	@DeleteMapping("/{idUserSkill}")
	@ApiOperation(value = "Deleta UserSkill por ID")
	public ResponseEntity<?> delete(@PathVariable("idUserSkill") Integer idUserSkill) {
		return userSkillService.delete(idUserSkill);
	}
	
}
