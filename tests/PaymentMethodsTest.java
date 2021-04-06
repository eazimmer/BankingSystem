package tests;

import code.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Cash;
import code.CheckingAccount;
import code.CreditCard;
import code.DebitCard;

class PaymentMethodsTest {
	
	@Test
	void testDebitCardPayment() {
		CheckingAccount account1 = new CheckingAccount(1111, 100);
		DebitCard debitcard = new DebitCard(account1);
		debitcard.charge(25);
		assertEquals(75, account1.getBalance());
	}
	
	
	@Test
	void testCreditCardPayment() {
		CreditCard creditcard = new CreditCard(1000);
		creditcard.charge(750);
		assertEquals(750, creditcard.getDebt());
	}
	
	
	@Test // SHOULD FAIL
	void testBitcoinPayment() {
		
		// Create a bitcoin wallet with 0.05 of a bitcoin
		// Will have an internal multiplier to represent the value of this coin in dollars
	
		BitcoinWallet bitcoin = new BitcoinWallet(0.05); 
		
		// Attempt to charge $1000 worth of bitcoin
		bitcoin.charge(1000);
		
		// Check to confirm wallet retains $1600 worth of bitcoin
		assertEquals(1600, bitcoin.getBalance());
	}

}
