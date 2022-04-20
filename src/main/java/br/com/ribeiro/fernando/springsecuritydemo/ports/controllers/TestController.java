package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping
	public String test() {
		return "Application is up and running!";
	}
	
}
