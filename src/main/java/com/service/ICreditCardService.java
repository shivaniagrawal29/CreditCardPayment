package com.service;

import java.util.List;



import com.entity.CreditCard;

public interface ICreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditcard)throws Throwable;
	public CreditCard removeCreditCard(String cardNumber) throws Throwable;
	public CreditCard updateCreditCard(String cardNumber, CreditCard creditcard) throws Throwable;
	public CreditCard getCreditCard(String cardNumber) throws Throwable;
	public List<CreditCard> getAllCreditCards()throws Throwable;
	
}
