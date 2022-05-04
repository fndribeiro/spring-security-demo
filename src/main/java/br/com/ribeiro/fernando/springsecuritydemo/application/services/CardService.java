package br.com.ribeiro.fernando.springsecuritydemo.application.services;

import java.util.List;

import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.CardDTO;
import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.User;

public interface CardService {

	List<CardDTO> getCardsDetails(User user);
	
}
