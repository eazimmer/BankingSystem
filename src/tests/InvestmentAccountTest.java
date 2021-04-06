package tests;

import code.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvestmentAccountTest {

	@Test
	void investmentAccountShortInvest() {
		CheckingAccount checkingAccount = new CheckingAccount(1111, 500);
		InvestmentAccount investAccount = new InvestmentAccount(2222, 0);
		checkingAccount.transfer(500, checkingAccount, investAccount);
		investAccount.shortInvest();
		assertEquals(1000, investAccount.getBalance());
		assertEquals(0, checkingAccount.getBalance());
	}
	
	@Test
	void investmentAccountLongInvest() {
		CheckingAccount checkingAccount = new CheckingAccount(1111, 500);
		InvestmentAccount investAccount = new InvestmentAccount(2222, 0);
		checkingAccount.transfer(500, checkingAccount, investAccount);
		investAccount.longInvest();
		assertEquals(5500, investAccount.getBalance());
		assertEquals(0, checkingAccount.getBalance());
	}

}
