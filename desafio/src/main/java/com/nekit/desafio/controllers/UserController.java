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

import com.nekit.desafio.DTOs.UserDTO;
import com.nekit.desafio.entities.User;
import com.nekit.desafio.forms.UserForm;
import com.nekit.desafio.services.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
// - - - - - - - GET ALL "User" - - - - - - -
	@GetMapping
	@ApiOperation(value = "Busca todos Usuários")
	public ResponseEntity<Page<UserDTO>> findAll(@PageableDefault(sort = "idUser", 
	direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Page<User> users = userService.findAll(paginacao);
		return ResponseEntity.ok(userService.convertObjToDTOwPages(users));
	}

// - - - - - - - GET "User" BY ID - - - - - - -
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca Usuário por ID do Usuário")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}
	
// - - - - - - - POST "User" - - - - - - -
	@Transactional
	@PostMapping
	@ApiOperation(value = "Cria novo Usuário")
	public ResponseEntity<String> insert(@Valid @RequestBody UserForm userForm) {
			
		User user = userService.convertFormToClass(userForm);
		user = userService.insert(user);
		// Returning URI with code
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdUser()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
// - - - - - - - UPDATE "User"  - - - - - - -
	@Transactional
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza Usuário por ID")
	public ResponseEntity<UserDTO> update(@Validated @RequestBody UserForm userForm, @PathVariable("id") Integer id) {
		User user = userService.convertFormToClass(userForm);
		
		return userService.update(user, id);
		
	}
	
// - - - - - - - DELETE "User" - - - - - - -
	@Transactional
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta Usuário por ID")
	public ResponseEntity<?> delete(@PathVariable("id") Integer idUser) {
		return userService.delete(idUser);
	}
}
