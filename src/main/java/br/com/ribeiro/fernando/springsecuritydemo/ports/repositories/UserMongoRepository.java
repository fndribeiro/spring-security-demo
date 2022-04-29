package br.com.ribeiro.fernando.springsecuritydemo.ports.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ribeiro.fernando.springsecuritydemo.application.datamappers.UserMongoDataMapper;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongoDataMapper, String> {

	@Query("{username:'?0'}")
	Optional<UserMongoDataMapper> findByUsername(String username);
	
}
