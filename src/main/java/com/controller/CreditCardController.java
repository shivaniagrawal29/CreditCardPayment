package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@Validated
@RestController
@RequestMapping("home")
public class CreditCardController {
	
	Log logger = LogFactory.getLog(AccountController.class);
	
	@Autowired
	CreditCardService creditcardservice;
	
	@PostMapping("/addcreditcard")
	public ResponseEntity<String> addCreditCard(@RequestBody @Valid CreditCard creditcard)
	{
		creditcardservice.addCreditCard(creditcard);
		ResponseEntity<String> re=new ResponseEntity<String>("Added Transaction Sucessfully !",HttpStatus.OK);
		logger.info("addCreditCard successful.");
		return re;
	}
	
	@DeleteMapping("/removecreditcard/{cardId}")
	public ResponseEntity<String> removeCreditCard(@PathVariable long cardId) throws Throwable {
		creditcardservice.removeCreditCard(cardId);
		ResponseEntity<String> re=new ResponseEntity<String>("Deleted Transaction Sucessfully !",HttpStatus.OK);
		logger.info("removeCreditCard successful.");
		return re;
	}
	
	@PutMapping("/updatecreditcard/{cardId}")
	public ResponseEntity<String> updateCreditCard(@PathVariable long cardId,@RequestBody @Valid CreditCard creditcard) throws Throwable{
		creditcardservice.updateCreditCard(cardId,creditcard);
		ResponseEntity<String> re=new ResponseEntity<String>("Updated Transaction Sucessfully !",HttpStatus.OK);
		logger.info("updateCreditCard successful.");
		return re;
	}
	
	@GetMapping("/getcreditcard/{cardId}")
	public CreditCard getCreditCard(@PathVariable long cardId) throws Throwable {
		CreditCard c1 = creditcardservice.getCreditCard(cardId);
		logger.info("getCreditCard successful.");
		return c1;
	}
	
	@GetMapping("/getcreditcards")
	public List<CreditCard> getAllCreditCards() {
		List<CreditCard> c = creditcardservice.getAllCreditCards();
		logger.info("getAllCreditCard successful.");
		return c;
	}
}
