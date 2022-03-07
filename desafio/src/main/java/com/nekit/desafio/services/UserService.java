package com.nekit.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nekit.desafio.DTOs.UserDTO;
import com.nekit.desafio.entities.User;
import com.nekit.desafio.forms.UserForm;
import com.nekit.desafio.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

// - - - - - - - GET ALL "User" - - - - - - - 
	public Page<User> findAll(Pageable paginacao) {
		return userRepository.findAll(paginacao);
	}
	
// - - - - - - - GET "User" BY ID - - - - - - -
	public ResponseEntity<UserDTO> findById(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		if(obj.isPresent()) {
			return ResponseEntity.ok(new UserDTO(obj.get()));
		}
		return ResponseEntity.notFound().build();
	}	
	
// - - - - - - - CREATE "User"  - - - - - - -
	public User insert(User obj) {
		obj = userRepository.save(obj);
		return obj;
	}
	
// - - - - - - - UPDATE "User"  - - - - - - -
	public ResponseEntity<UserDTO> update(User obj, Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			user.get().setLogin(obj.getLogin());
			user.get().setPassword(obj.getPassword());
			return ResponseEntity.ok(new UserDTO(user.get()));
		}
		return ResponseEntity.notFound().build();
	}

// - - - - - - - DELETE "User" - - - - - - -
	public ResponseEntity<?> delete(Integer idUser) {
		Optional<User> user = userRepository.findById(idUser);
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
// - - - - - - - - - - - - - - - - CONVERTIONS - - - - - - - - - - - - - - - - - -
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
// - - - - - - - CLASS TO DTO with PAGES - - - - - - -	
	public Page<UserDTO>  convertObjToDTOwPages(Page<User> users) {
		return users.map(UserDTO::new);
	}
	
// - - - - - - - FORM TO CLASS - - - - - - -
	public User convertFormToClass(UserForm userForm) {
		return new User(userForm);
	}


}
