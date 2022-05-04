package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.UserDTO;
import br.com.ribeiro.fernando.springsecuritydemo.application.services.UserService;

@RestController
@RequestMapping(ControllersURIs.USER)
public class LoginController {

	private UserService service;

	public LoginController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public UserDTO getUserDetailsAfterLogin(Principal user) {
		return service.findByUsername(user.getName());
	}
	
}
