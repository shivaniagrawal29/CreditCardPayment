package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CreditCard;
import com.service.CreditCardService;

@RestController
@RequestMapping("home")
public class CreditCardController {
	
	@Autowired
	CreditCardService creditcardservice;
	
	@PostMapping("/addcreditcard")
	public CreditCard addCreditCard(@RequestBody CreditCard creditcard)
	{
		CreditCard c1 = creditcardservice.addCreditCard(creditcard);
		return c1;
	}
	
	@DeleteMapping("/removecreditcard/{cardId}")
	public CreditCard removeCreditCard(@PathVariable long cardId) {
		CreditCard c1 = creditcardservice.removeCreditCard(cardId);
		
		return c1;
	}
	
	@PutMapping("/updatecreditcard/{cardId}")
	public CreditCard updateCreditCard(@PathVariable long cardId,@RequestBody CreditCard creditcard) {
		CreditCard c1 = creditcardservice.updateCreditCard(cardId,creditcard);
		return c1;
	}
	
	@GetMapping("/getcreditcard/{cardId}")
	public CreditCard getCreditCard(@PathVariable long cardId) {
		CreditCard c1 = creditcardservice.getCreditCard(cardId);
		return c1;
	}
	
	@GetMapping("/getcreditcards")
	public List<CreditCard> getAllCreditCards() {
		List<CreditCard> c = creditcardservice.getAllCreditCards();
		return c;
	}
}
