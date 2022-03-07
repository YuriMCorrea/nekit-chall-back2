package com.nekit.desafio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nekit.desafio.DTOs.TokenDTO;
import com.nekit.desafio.forms.LoginForm;
import com.nekit.desafio.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm loginForm){
		UsernamePasswordAuthenticationToken dataLogin = loginForm.converter();

		try {
			Authentication authentication = authManager.authenticate(dataLogin);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
			
		} catch(AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
