package com.nekit.desafio.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nekit.desafio.entities.User;
import com.nekit.desafio.repositories.UserRepository;

public class AuthViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	private UserRepository userRepository;
	
	
// ---- CONSTRUCTOR
	//--Full
	public AuthViaTokenFilter(TokenService tokenService, UserRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValid(token);
		if (valido) {
			autenticarUsuario(token);
		}
		filterChain.doFilter(request, response);
	}

	private void autenticarUsuario(String token) {
		Integer idUsuario = tokenService.getIdUsuario(token);
		User user = userRepository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;			
		}
		return token.substring(7, token.length());
	}
}
