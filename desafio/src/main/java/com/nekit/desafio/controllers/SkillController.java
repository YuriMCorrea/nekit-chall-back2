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

import com.nekit.desafio.DTOs.SkillDTO;
import com.nekit.desafio.entities.Skill;
import com.nekit.desafio.forms.SkillForm;
import com.nekit.desafio.services.SkillService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/skill")
public class SkillController {
	@Autowired
	private SkillService skillService;
	
// - - - - - - - GET ALL "Skill" - - - - - - -
	@GetMapping
	@ApiOperation(value = "Busca todas Skills")
	public ResponseEntity<Page<SkillDTO>> findAll(@PageableDefault(sort = "idSkill", 
	direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

	Page<Skill> skills = skillService.findAll(paginacao);
	return ResponseEntity.ok(skillService.convertObjToDTOwPages(skills));
	}

// - - - - - - - GET "Skill" BY ID - - - - - - -
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca Skill por ID da Skill")
	public ResponseEntity<SkillDTO> findById(@PathVariable("id") Integer id) {
		return skillService.findById(id);
	}
	
// - - - - - - - POST "Skill" - - - - - - -
	@Transactional
	@PostMapping
	@ApiOperation(value = "Cria nova Skill")
	public ResponseEntity<String> insert(@Valid @RequestBody SkillForm skillForm) {
			
		Skill skill = skillService.convertFormToClass(skillForm);
		skill = skillService.insert(skill);
		// Returning URI with code
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(skill.getIdSkill()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
// - - - - - - - UPDATE "Skill"  - - - - - - -
	@Transactional
	@PutMapping("/{id}")
	@ApiOperation(value = "Edita Skill por ID")
	public ResponseEntity<SkillDTO> update(@Validated @RequestBody SkillForm skillForm, @PathVariable("id") Integer id) {
		Skill skill = skillService.convertFormToClass(skillForm);
		
		return skillService.update(skill, id);
		
	}
	
// - - - - - - - DELETE "Skill" - - - - - - -
	@Transactional
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta Skill por ID")
	public ResponseEntity<?> delete(@PathVariable("id") Integer idSkill) {
		return skillService.delete(idSkill);
	}
	
}
