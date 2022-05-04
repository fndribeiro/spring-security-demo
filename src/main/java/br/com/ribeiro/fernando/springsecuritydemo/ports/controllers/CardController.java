package br.com.ribeiro.fernando.springsecuritydemo.ports.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.CardDTO;
import br.com.ribeiro.fernando.springsecuritydemo.application.services.CardService;
import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.User;

@RestController
@RequestMapping(ControllersURIs.CARD)
public class CardController {
	
	private CardService service;
	
	public CardController(CardService service) {
		this.service = service;
	}

	@PostMapping
	public List<CardDTO> getCardDetails(@RequestBody User user) {
		return service.getCardsDetails(user);
	}
	
}
