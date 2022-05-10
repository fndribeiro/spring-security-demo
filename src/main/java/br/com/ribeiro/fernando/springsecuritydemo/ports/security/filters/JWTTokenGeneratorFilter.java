package br.com.ribeiro.fernando.springsecuritydemo.ports.security.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.ribeiro.fernando.springsecuritydemo.ports.controllers.ControllersURIs;
import br.com.ribeiro.fernando.springsecuritydemo.ports.security.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		Authentication authentication = SecurityContextHolder
			.getContext()
			.getAuthentication();
		
		if (authentication != null) {
			
			SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
			
			Date issuedAt = new Date();
			
			String jwt = Jwts
				.builder()
				.setIssuer(SecurityConstants.ISSUER)
				.setSubject(SecurityConstants.SUBJECT)
				.claim(SecurityConstants.USERNAME, authentication.getName())
				.claim(SecurityConstants.AUTHORITIES, populateAuthorities(authentication.getAuthorities()))
				.setIssuedAt(issuedAt)
				.setExpiration(new Date(issuedAt.getTime() + SecurityConstants.TOKEN_EXPIRATION))
				.signWith(secretKey)
				.compact();
			
			response.setHeader(HttpHeaders.AUTHORIZATION, jwt);
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return !request
				.getServletPath()
				.equals(ControllersURIs.USERS + ControllersURIs.LOGIN);
	}
	
	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		
		Set<String> authoritiesSet = new HashSet<>();
		
		collection.forEach(authority -> authoritiesSet.add(authority.getAuthority()));
		
        return String.join(",", authoritiesSet);
	}

}
