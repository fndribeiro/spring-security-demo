package br.com.ribeiro.fernando.springsecuritydemo.application.services;

import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.UserDTO;

public interface UserService {

	UserDTO findByUsername(String username);
	
}
