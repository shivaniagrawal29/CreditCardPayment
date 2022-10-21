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

import com.advices.EntityAlreadyExistsException;
import com.advices.NoRecordFoundException;
import com.entity.CreditCard;
import com.service.CreditCardService;

@Validated
@RestController
@RequestMapping("home")
public class CreditCardController {
	
	Log logger = LogFactory.getLog(CreditCardController.class);
	
	@Autowired
	CreditCardService creditcardservice;
	
	@PostMapping("/addcreditcard")
	public ResponseEntity<String> addCreditCard(@RequestBody @Valid CreditCard creditcard)throws Throwable
	{
		try {
		creditcardservice.addCreditCard(creditcard);
		ResponseEntity<String> re=new ResponseEntity<String>("Added credit card Sucessfully !",HttpStatus.OK);
		logger.info("addCreditCard successful.");
		return re;
		}
		   catch(EntityAlreadyExistsException e)
	       {
	    	   throw new EntityAlreadyExistsException("CreditCard already exists in database !!");
	       }
	}
	
	@DeleteMapping("/removecreditcard/{cardNumber}")
	public ResponseEntity<String> removeCreditCard(@PathVariable String cardNumber) throws Throwable {
		creditcardservice.removeCreditCard(cardNumber);
		ResponseEntity<String> re=new ResponseEntity<String>("Deleted credit card Sucessfully !",HttpStatus.OK);
		logger.info("removeCreditCard successful.");
		return re;
	}
	
	@PutMapping("/updatecreditcard/{cardNumber}")
	public ResponseEntity<String> updateCreditCard(@PathVariable String cardNumber,@RequestBody @Valid CreditCard creditcard) throws Throwable{
		creditcardservice.updateCreditCard(cardNumber,creditcard);
		ResponseEntity<String> re=new ResponseEntity<String>("Updated credit card Sucessfully !",HttpStatus.OK);
		logger.info("updateCreditCard successful.");
		return re;
	}
	
	@GetMapping("/getcreditcard/{cardNumber}")
	public CreditCard getCreditCard(@PathVariable String cardNumber) throws Throwable {
		CreditCard c1 = creditcardservice.getCreditCard(cardNumber);
		logger.info("getCreditCard successful.");
		return c1;
	}
	
	@GetMapping("/getcreditcards")
	public List<CreditCard> getAllCreditCards() throws Throwable{
		List<CreditCard> creditcards = creditcardservice.getAllCreditCards();
		if(creditcards.isEmpty()) {
			   throw new NoRecordFoundException("NO Records found in database !!");
		}
		logger.info("getAllCreditCard successful.");
		return creditcards;
	}
}
