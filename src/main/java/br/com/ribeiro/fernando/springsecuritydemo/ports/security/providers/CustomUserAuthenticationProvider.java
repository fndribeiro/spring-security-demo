package br.com.ribeiro.fernando.springsecuritydemo.ports.security.providers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.ribeiro.fernando.springsecuritydemo.application.datamappers.UserMongoDataMapper;
import br.com.ribeiro.fernando.springsecuritydemo.ports.repositories.UserMongoRepository;

public class CustomUserAuthenticationProvider implements AuthenticationProvider {
	
	private UserMongoRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public CustomUserAuthenticationProvider(UserMongoRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		Optional<UserMongoDataMapper> user = userRepository.findByUsername(username);
		
		if (user.isPresent()) {
			
			if (passwordEncoder.matches(password, user.get().getPassword())) {
				
				Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
				
				user
					.get()
				 	.getAuthorities()
				 	.forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority.name())));
				
				return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
				
			}
		}
		
		throw new BadCredentialsException("Invalid username or password.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
