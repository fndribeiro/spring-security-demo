package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllersURIs.BALANCE)
public class BalanceController {
	
	@GetMapping
	public String getBalanceDetails(String input) {
		return "OK";
	}
	
}
