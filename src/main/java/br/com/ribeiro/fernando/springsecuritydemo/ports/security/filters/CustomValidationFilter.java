package br.com.ribeiro.fernando.springsecuritydemo.ports.security.filters;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;

public class CustomValidationFilter implements Filter {

	private final String authenticationSchemeBasic = "basic";
	private final String invalidUsernameWord = "test";
	private final Charset credentialsCharset = StandardCharsets.UTF_8;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		
		String header = rq.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (header != null && !header.isBlank()) {
			
			if (header.toLowerCase().startsWith(authenticationSchemeBasic)) {
				
				byte[] base64Token = header
					.substring(6)
					.getBytes(credentialsCharset);
				
				byte[] decodedToken = Base64
					.getDecoder()
					.decode(base64Token);
				
				String token = new String(decodedToken, credentialsCharset);
				
				int delimiter = token.indexOf(":");
				
				if (delimiter == -1) {
					throw new BadCredentialsException("Invalid basic authentication token");
				}
				
				String username = token.substring(0, delimiter);
				
				if (username.toLowerCase().contains(invalidUsernameWord)) {
					rs.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}
				
			}
			
		}
		
		chain.doFilter(request, response);
		
	}

}
