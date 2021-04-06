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
}
