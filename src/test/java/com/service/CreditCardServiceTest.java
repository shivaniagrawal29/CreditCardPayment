package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.CreditCard;
import com.repository.ICreditCardRepository;

@SpringBootTest
class CreditCardServiceTest {
	
	@Autowired
	CreditCardService creditcardservice;
	
	@MockBean
	ICreditCardRepository creditcardrepo;
	
	@Test
	void testAddCreditCard() throws Throwable{
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		Mockito.when(creditcardrepo.save(c1)).thenReturn(c1);
		assertThat(creditcardservice.addCreditCard(c1)).isEqualTo(c1);
	}

	@Test
	void testRemoveCreditCard() {
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		CreditCard c2 = c1;
		Mockito.when(creditcardrepo.findByCardNumber("1234567")).thenReturn(c2);
		Mockito.when(creditcardrepo.existsByCardNumber(c1.getCardNumber())).thenReturn(false);
		assertFalse(creditcardrepo.existsByCardNumber(c1.getCardNumber()));
	}

	@Test
	void testUpdateCreditCard() throws Throwable{
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		CreditCard c2 = c1;
		Mockito.when(creditcardrepo.findByCardNumber("1234567")).thenReturn(c2);
		Mockito.when(creditcardrepo.existsByCardNumber(c1.getCardNumber())).thenReturn(false);
		
		c1.setBankName("ICICI");
		c1.setCardName("abcdef");
		c1.setCardNumber("1234567");
		c1.setCardType("Debit");
		c1.setExpiryDate(LocalDate.of(2019, 2, 13));
		
		assertThat(creditcardservice.updateCreditCard("1234567", c1)).isEqualTo(c1);
	}

	@Test
	void testGetCreditCard() throws Throwable {
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		CreditCard c2 = c1;
		Mockito.when(creditcardrepo.findByCardNumber("1234567")).thenReturn(c2);
		assertThat(creditcardservice.getCreditCard("1234567")).isEqualTo(c1);
		
	}

	@Test
	void testGetAllCreditCards() throws Throwable{
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		CreditCard c2 = new CreditCard();
		c2.setId(2);
		c2.setBankName("SBI");
		c2.setCardName("xyz");
		c2.setCardNumber("122333367");
		c2.setCardType("Touch to Pay");
		c2.setExpiryDate(LocalDate.of(2020, 12, 23));
		
		List<CreditCard> creditcards = new ArrayList<>();
		creditcards.add(c1);
		creditcards.add(c2);
		
		Mockito.when(creditcardrepo.findAll()).thenReturn(creditcards);
		assertThat(creditcardservice.getAllCreditCards()).isEqualTo(creditcards);
	}

}
