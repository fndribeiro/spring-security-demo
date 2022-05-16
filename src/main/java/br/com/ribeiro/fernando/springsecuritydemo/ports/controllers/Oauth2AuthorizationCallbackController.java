package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Oauth2AuthorizationCallbackController {
	
	@GetMapping
	public String main(OAuth2AuthenticationToken token) {
		return "User: " + token.getPrincipal() + " logged in!";
	}
	
}
