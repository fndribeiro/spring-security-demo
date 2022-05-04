package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.UserDTO;
import br.com.ribeiro.fernando.springsecuritydemo.application.services.UserService;

@RestController
@RequestMapping(ControllersURIs.USER)
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/{username}")
	public UserDTO getUserDetails(@PathVariable(value = "username") String username) {
		return service.findByUsername(username);
	}
	
}
