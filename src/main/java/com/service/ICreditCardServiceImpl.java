package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.CreditCard;
import com.repository.ICreditCardRepository;


@Service
public class ICreditCardServiceImpl implements ICreditCardService {
	@Autowired
	ICreditCardRepository creditcardrepo;
	
	@Override
	public CreditCard addCreditCard(CreditCard creditcard)
	{
		CreditCard c1 = creditcardrepo.save(creditcard);
		return c1;
	}

	@Override
	public CreditCard removeCreditCard(long cardId) {	
		CreditCard c1 = creditcardrepo.findById(cardId).orElseThrow();
		creditcardrepo.deleteById(cardId);
		return c1;
	}

	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard) {
		CreditCard c1 = creditcardrepo.findById(cardId).orElseThrow();
		c1.setBankName(creditcard.getBankName());
		c1.setCardName(creditcard.getCardName());
		c1.setCardNumber(creditcard.getCardNumber());
		c1.setCardType(creditcard.getCardType());
		c1.setExpiryDate(creditcard.getExpiryDate());
		c1.setCustomer(c1.getCustomer());
		creditcardrepo.save(c1);
		return c1;
	}

	@Override
	public CreditCard getCreditCard(long cardId) {
		CreditCard c1 = creditcardrepo.findById(cardId).orElseThrow();
		return c1;
	}

	@Override
	public List<CreditCard> getAllCreditCards() {
		List<CreditCard> c = creditcardrepo.findAll(); 
		return c;
	}
}
