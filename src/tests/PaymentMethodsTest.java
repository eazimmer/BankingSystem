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
	
	
	@Test
	void testBitcoinCashPayment() {
		Bitcoin coin = new Bitcoin(1.0);
		coin.charge(5000);
		assertEquals(15000, coin.getCashBalance());
		assertEquals(0.75, coin.getCoinBalance());
	}
	
	
	@Test
	void testBitcoinCoinsPayment() {
		Bitcoin coin = new Bitcoin(1.0);
		coin.chargeCoins(0.5);
		assertEquals(10000, coin.getCashBalance());
		assertEquals(0.5, coin.getCoinBalance());
	}
}
