package br.com.ribeiro.fernando.springsecuritydemo.ports.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ribeiro.fernando.springsecuritydemo.application.datamappers.UserMongoDataMapper;
import br.com.ribeiro.fernando.springsecuritydemo.ports.repositories.UserMongoRepository;
import br.com.ribeiro.fernando.springsecuritydemo.ports.security.managers.UserSecurityManager;

@Service
public class MongoUserDetailsServiceImpl implements UserDetailsService {
	
	private UserMongoRepository userRepository;
	
	public MongoUserDetailsServiceImpl(UserMongoRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserMongoDataMapper user = userRepository
			.findByUsername(username)
			.orElseThrow();
		
		return new UserSecurityManager(user);
	}

	
	
}
