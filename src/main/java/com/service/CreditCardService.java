package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IdAlreadyExistsException;
import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.Account;
import com.entity.CreditCard;
import com.repository.ICreditCardRepository;

@Service
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class CreditCardService implements ICreditCardService {
	@Autowired
	ICreditCardRepository creditcardrepo;
	
	@Override
	public CreditCard addCreditCard(CreditCard creditcard)throws Throwable
	{
	 	if( !creditcardrepo.findById(creditcard.getId()).isEmpty()  )
		{
			throw new IdAlreadyExistsException("CreditCard already exists in database !!");
		}
		return creditcardrepo.save(creditcard);	
	
	}

	@Override
	public CreditCard removeCreditCard(long cardId) throws Throwable {	
		Supplier s = ()-> new ResourceNotFoundException("Creditcard doesn't exist in the database.");
		CreditCard c1 = creditcardrepo.findById(cardId).orElseThrow(s);
		creditcardrepo.deleteById(cardId);
		return c1;
	}

	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard) throws Throwable{
		
		Supplier s = ()-> new ResourceNotFoundException("Creditcard doesn't exist in the database.");	
		CreditCard c1 = creditcardrepo.findById(cardId).orElseThrow(s);
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
	public CreditCard getCreditCard(long cardId) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Creditcard doesn't exist in the database.");
		CreditCard c1 = creditcardrepo.findById(cardId).orElseThrow(s);
		return c1;
	}

	@Override
	public List<CreditCard> getAllCreditCards() throws Throwable{
		List<CreditCard> creditcards = creditcardrepo.findAll(); 
	
		if(creditcards.isEmpty())
		{	throw new NoRecordFoundException("NO Records found in database !!");
		}
		return creditcards;

}
}