package com.service;

import java.util.List;



import com.entity.CreditCard;

public interface ICreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditcard)throws Throwable;
	public CreditCard removeCreditCard(long cardId) throws Throwable;
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard)throws Throwable;
	public CreditCard getCreditCard(long cardId) throws Throwable;
	public List<CreditCard> getAllCreditCards()throws Throwable;
}
