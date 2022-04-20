package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllersURIs.ACCOUNT)
public class AccountController {
	
	@GetMapping
	public String getAccountDetails(String input) {
		return "OK";
	}
	
}
