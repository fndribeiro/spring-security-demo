package br.com.ribeiro.fernando.springsecuritydemo.domain.entities;

import java.util.Date;

public class Card {
	
	private String userId;
	private String cardNumber;
	private String cardType;
	private int totalLimit;
	private int amountUsed;
	private int availableAmount;
	private Date createDt;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public int getTotalLimit() {
		return totalLimit;
	}
	
	public void setTotalLimit(int totalLimit) {
		this.totalLimit = totalLimit;
	}
	
	public int getAmountUsed() {
		return amountUsed;
	}
	
	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}
	
	public int getAvailableAmount() {
		return availableAmount;
	}
	
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	
	public Date getCreateDt() {
		return createDt;
	}
	
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
}
