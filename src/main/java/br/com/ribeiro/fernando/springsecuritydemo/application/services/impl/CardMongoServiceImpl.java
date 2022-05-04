package br.com.ribeiro.fernando.springsecuritydemo.application.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.ribeiro.fernando.springsecuritydemo.application.datamappers.CardMongoDataMapper;
import br.com.ribeiro.fernando.springsecuritydemo.application.dtos.CardDTO;
import br.com.ribeiro.fernando.springsecuritydemo.application.services.CardService;
import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.User;
import br.com.ribeiro.fernando.springsecuritydemo.ports.repositories.CardMongoRepository;

@Service
public class CardMongoServiceImpl implements CardService {
	
	private CardMongoRepository repository;
	
	public CardMongoServiceImpl(CardMongoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<CardDTO> getCardsDetails(User user) {
		
		List<CardMongoDataMapper> cards = repository.findByUserId(user.getUsername());
		
		return cards
			.stream()
			.map(card -> {
				return new CardDTO(card);
			})
			.collect(Collectors.toList());
		
	}
	
}
