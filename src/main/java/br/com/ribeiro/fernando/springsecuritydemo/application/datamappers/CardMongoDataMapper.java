package br.com.ribeiro.fernando.springsecuritydemo.application.datamappers;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.Card;

@Document("cards")
public class CardMongoDataMapper extends Card {
	
	@MongoId
	private ObjectId id;

	public CardMongoDataMapper() {}

	public CardMongoDataMapper(Card card) {
		setUserId(card.getUserId());
		setCardNumber(card.getCardNumber());
		setCardType(card.getCardType());
		setTotalLimit(card.getTotalLimit());
		setAmountUsed(card.getAmountUsed());
		setAvailableAmount(card.getAvailableAmount());
		setCreateDt(card.getCreateDt());
	}
	
	

}
