package br.com.ribeiro.fernando.springsecuritydemo.ports.security.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.ribeiro.fernando.springsecuritydemo.ports.controllers.ControllersURIs;
import br.com.ribeiro.fernando.springsecuritydemo.ports.security.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenValidationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (jwt != null && !jwt.isBlank()) {
			
			SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
			
			try {
				
				Claims claims = Jwts
						.parserBuilder()
						.setSigningKey(secretKey)
						.build()
						.parseClaimsJws(jwt)
						.getBody();
				
				String username = (String) claims.get(SecurityConstants.USERNAME);
				String authorities = (String) claims.get(SecurityConstants.AUTHORITIES);
				
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				
				SecurityContextHolder
					.getContext()
					.setAuthentication(auth);
				
			} catch (ExpiredJwtException e) {
				
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				
				response
					.getOutputStream()
					.print("Expired token.");
				
				return;
				
			} catch (Exception e) {
				
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				
				response
					.getOutputStream()
					.print("Invalid token.");
				
				return;
			
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return request
			.getServletPath()
			.equals(ControllersURIs.USERS + ControllersURIs.LOGIN);
	}
	
	@Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
	
}
