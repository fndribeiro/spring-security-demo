package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllersURIs.USERS + ControllersURIs.LOGIN)
public class LoginController {
	
	@GetMapping
	public String loginUser() {
		return "OK";
	}
	
}
