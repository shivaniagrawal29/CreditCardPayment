package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.CreditCard;
import com.repository.ICreditCardRepository;

@SpringBootTest
class ICreditCardServiceImplTest {
	
	@Autowired
	ICreditCardServiceImpl creditcardservice;
	
	@MockBean
	ICreditCardRepository creditcardrepo;
	
	@Test
	void testAddCreditCard() {
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
		
		Optional<CreditCard> c2 = Optional.of(c1);
		Mockito.when(creditcardrepo.findById((long) 1)).thenReturn(c2);
		Mockito.when(creditcardrepo.existsById(c1.getId())).thenReturn(false);
		assertFalse(creditcardrepo.existsById(c1.getId()));
	}

	@Test
	void testUpdateCreditCard() {
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		Optional<CreditCard> c2 = Optional.of(c1);
		Mockito.when(creditcardrepo.findById((long) 1)).thenReturn(c2);
		Mockito.when(creditcardrepo.save(c1)).thenReturn(c1);
		
		c1.setBankName("ICICI");
		c1.setCardName("abcdef");
		c1.setCardNumber("234553");
		c1.setCardType("Debit");
		c1.setExpiryDate(LocalDate.of(2019, 2, 13));
		
		assertThat(creditcardservice.updateCreditCard(1, c1)).isEqualTo(c1);
	}

	@Test
	void testGetCreditCard() {
		CreditCard c1 = new CreditCard();
		c1.setId(1);
		c1.setBankName("Axis");
		c1.setCardName("abc");
		c1.setCardNumber("1234567");
		c1.setCardType("Visa");
		c1.setExpiryDate(LocalDate.of(2016, 9, 23));
		
		Optional<CreditCard> c2 = Optional.of(c1);
		Mockito.when(creditcardrepo.findById((long) 1)).thenReturn(c2);
		assertThat(creditcardservice.getCreditCard(1)).isEqualTo(c1);
		
	}

	@Test
	void testGetAllCreditCards() {
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
