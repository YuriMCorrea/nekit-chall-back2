package com.nekit.desafio.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nekit.desafio.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	//@Value("$(com.nekit.desafio.desafio.jwt.expiration)")
	private int expiration = 86400000;
	
	@Value("$(com.nekit.desafio.jwt.secret)")
	private String secret;
	
	
	public String gerarToken(Authentication authentication) {
		User logado = (User) authentication.getPrincipal();
		Date hoje = new Date();
		Date exp = new Date(hoje.getTime() + expiration);
		
		return Jwts.builder()
				.setIssuer("API Desafio Neki-iT")
				.setSubject(logado.getIdUser().toString())
				.setIssuedAt(hoje)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
