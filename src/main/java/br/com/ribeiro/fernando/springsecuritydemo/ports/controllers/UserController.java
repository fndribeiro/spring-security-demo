package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.UserDTO;
import br.com.ribeiro.fernando.springsecuritydemo.application.services.UserService;

@RestController
@RequestMapping(ControllersURIs.USERS)
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/{username}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable(value = "username") String username) {
		
		UserDTO user = service.findByUsername(username);
		
		if (user == null) {
			return ResponseEntity
				.notFound()
				.build();
		}
		
		return ResponseEntity.ok(user);
	}
	
}
