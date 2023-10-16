package com.rubenfilipe07.gerenciadortarefas.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
	    String token = recoverToken(request);

	    if (token != null) {
	        String email = tokenService.validateToken(token);

	        if (email != null) {
	            UserDetails usuario = usuarioRepository.findByEmail(email);

	            if (usuario != null) {
	                SecurityContextHolder.getContext().setAuthentication(
	                    new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities())
	                );
	            }
	        }
	    }

	    filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			return null;
		}
		return authHeader;
	}

}
