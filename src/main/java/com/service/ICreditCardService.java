package com.service;

import java.util.List;



import com.entity.CreditCard;

public interface ICreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditcard);
	public CreditCard removeCreditCard(long cardId);
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard);
	public CreditCard getCreditCard(long cardId);
	public List<CreditCard> getAllCreditCards();
}
