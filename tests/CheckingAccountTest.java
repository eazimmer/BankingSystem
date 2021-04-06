package tests;

import code.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckingAccountTest {

	@Test
	void checkingAccountBalanceTest() {
		CheckingAccount checking = new CheckingAccount(1, 500);
		assertEquals(500, checking.getBalance());
	}
	
	@Test
	void checkingAccountWithdrawTest() {
		CheckingAccount checking = new CheckingAccount(1, 500);
		checking.withdraw(250, "irrelevant");
		assertEquals(250, checking.getBalance());
	}
	
	@Test
	void checkingAccountdDepositTest() {
		CheckingAccount checking = new CheckingAccount(1, 250);
		checking.deposit(250, "irrelevant");
		assertEquals(500, checking.getBalance());
	}
}
