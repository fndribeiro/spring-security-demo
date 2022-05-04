package br.com.ribeiro.fernando.springsecuritydemo.application.dtos;

import java.util.Date;

import br.com.ribeiro.fernando.springsecuritydemo.domain.entities.Card;

public class CardDTO {
	
	private String cardNumberFirst6Digits;
	private String cardNumberLast4Digits;
	private String cardType;
	private int totalLimit;
	private int amountUsed;
	private int availableAmount;
	private Date createDt;
	
	public CardDTO(Card card) {
		this.cardNumberFirst6Digits = card.getCardNumber().substring(0, 6);
		this.cardNumberLast4Digits = card.getCardNumber().substring(12);
		this.cardType = card.getCardNumber();
		this.totalLimit = card.getTotalLimit();
		this.amountUsed = card.getAmountUsed();
		this.availableAmount = card.getAvailableAmount();
		this.createDt = card.getCreateDt();
	}

	public String getCardNumberFirst6Digits() {
		return cardNumberFirst6Digits;
	}

	public String getCardNumberLast4Digits() {
		return cardNumberLast4Digits;
	}

	public String getCardType() {
		return cardType;
	}

	public int getTotalLimit() {
		return totalLimit;
	}

	public int getAmountUsed() {
		return amountUsed;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public Date getCreateDt() {
		return createDt;
	}
	
}
