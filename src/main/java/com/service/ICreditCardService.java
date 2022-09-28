package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.CreditCard;

@Service
public interface ICreditCardService {
	public CreditCard addCreditCard(CreditCard creditcard);
	public CreditCard removeCreditCard(long cardId);
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard);
	public CreditCard getCreditCard(long cardId);
	public List<CreditCard> getAllCreditCards();
}
