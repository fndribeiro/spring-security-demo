package br.com.ribeiro.fernando.springsecuritydemo.ports.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiro.fernando.springsecuritydemo.application.datamappers.CardMongoDataMapper;

@Repository
public interface CardMongoRepository extends MongoRepository<CardMongoDataMapper, String>{

	List<CardMongoDataMapper> findByUserId(String customerId);
	
}
