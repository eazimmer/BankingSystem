package tests;

import code.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.CheckingAccount;

class SavingsAccountTest {

	@Test
	void savingsAccountBalanceTest() {
		SavingsAccount savings = new SavingsAccount(1, 500, 5);
		assertEquals(500, savings.getBalance());
	}

	@Test
	void savingsAccountdDepositTest() {
		SavingsAccount savings = new SavingsAccount(1, 250, 5);
		savings.deposit(250, "irrelevant");
		assertEquals(500, savings.getBalance());
	}
	
	@Test
	void savingsAccountEarnInterestTest() {
		SavingsAccount savings = new SavingsAccount(1, 500, 5);
		savings.earnInterest();
		assertEquals(525, savings.getBalance());
	}

}
