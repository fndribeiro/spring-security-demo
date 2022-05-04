package br.com.ribeiro.fernando.springsecuritydemo.application.datamappers;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.User;

@Document("users")
public class UserMongoDataMapper extends User {

	@MongoId
	private ObjectId id;
	
	public UserMongoDataMapper() {}

}
