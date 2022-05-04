package br.com.ribeiro.fernando.springsecuritydemo.application.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ribeiro.fernando.springsecuritydemo.application.datamappers.UserMongoDataMapper;
import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.UserDTO;
import br.com.ribeiro.fernando.springsecuritydemo.application.services.UserService;
import br.com.ribeiro.fernando.springsecuritydemo.ports.repositories.UserMongoRepository;

@Service
public class UserMongoServiceImpl implements UserService {
	
	private UserMongoRepository repository;
	
	public UserMongoServiceImpl(UserMongoRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDTO findByUsername(String username) {
		
		Optional<UserMongoDataMapper> user = repository.findByUsername(username);
		
		if (user.isPresent()) {
			return new UserDTO(user.get());
		}
		
		return null;
	}

}
