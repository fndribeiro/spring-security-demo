package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllersURIs.CONTACT)
public class ContactController {
	
	@GetMapping
	public String saveContactInquiryDetails(String input) {
		return "OK";
	}
	
}
