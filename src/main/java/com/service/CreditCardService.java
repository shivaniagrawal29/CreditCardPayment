package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.CreditCard;
import com.repository.ICreditCardRepository;

@Service
public class CreditCardService implements ICreditCardService {
	@Autowired
	ICreditCardRepository creditcardrepo;
	
	@Override
	public CreditCard addCreditCard(CreditCard creditcard)throws Throwable
	{
		return creditcardrepo.save(creditcard);	
	}

	@Override
	public CreditCard removeCreditCard(String cardNumber) throws Throwable {
		CreditCard c = creditcardrepo.findByCardNumber(cardNumber);
		if(c==null){
            throw new ResourceNotFoundException("Creditcard doesn't exist in the database.");
        }
		creditcardrepo.delete(creditcardrepo.findByCardNumber(cardNumber));
		return c;
	}

	@Override
	public CreditCard updateCreditCard(String cardNumber, CreditCard creditcard) throws Throwable{
		CreditCard c1 = creditcardrepo.findByCardNumber(cardNumber);
		
		if(c1==null){
            throw new ResourceNotFoundException("Creditcard doesn't exist in the database.");
        }
		
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
	public CreditCard getCreditCard(String cardNumber) throws Throwable {
		CreditCard c1 = creditcardrepo.findByCardNumber(cardNumber);
		if(c1==null){
            throw new ResourceNotFoundException("Creditcard doesn't exist in the database.");
        }
		return c1;
	}

	@Override
	public List<CreditCard> getAllCreditCards() throws Throwable{
		List<CreditCard> creditcards = creditcardrepo.findAll(); 
		if(creditcards.isEmpty()){
			throw new NoRecordFoundException("NO Records found in database !!");
		}
		return creditcards;

}
}