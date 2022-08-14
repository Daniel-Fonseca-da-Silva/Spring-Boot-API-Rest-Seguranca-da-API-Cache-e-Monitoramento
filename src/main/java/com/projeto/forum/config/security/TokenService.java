package com.projeto.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.projeto.forum.modelo.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	// @Value() -> Captura dados do application.properties
	@Value("${forum.jwt.expiration}")
	private static String expiration;
	
	@Value("${forum.jwt.secret}")
	private static String secret;

	public static String gerarToken(Authentication authentication) {
		Date hoje = new Date();
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("API do forum da Alura")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	
	}

}
