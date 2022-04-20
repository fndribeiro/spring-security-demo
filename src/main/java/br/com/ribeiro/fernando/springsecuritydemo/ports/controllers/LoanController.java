package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllersURIs.LOAN)
public class LoanController {
	
	@GetMapping
	public String getLoanDetails(String input) {
		return "OK";
	}
	
}
