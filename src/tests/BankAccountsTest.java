package tests;

import code.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BankAccountsTest {

	@Test
	void testCheckingTransactionLog() {
		CheckingAccount checking = new CheckingAccount(1111, 500);
		CheckingAccount checking2 = new CheckingAccount(1112, 0);
		ArrayList<String> log = new ArrayList<String>();

		// Test Deposit Logging Functionality
		checking.deposit(500, "Virtual");
		log.add("DEPOSIT: received 500.");
		assertEquals(log, checking.getTransactionLog());

		// Test Withdraw Logging Functionality
		checking.withdraw(250, "Virtual");
		log.add("WITHDRAW: withdrew 250 from the account.");
		assertEquals(log, checking.getTransactionLog());
		
		// Test Transfer Logging Functionality
		checking.transfer(100, checking, checking2);
		log.add("TRANSFER: sent 100 to another account.");
		assertEquals(log, checking.getTransactionLog());
	}
	
	@Test
	void testSavingsTransactionLog() {
		SavingsAccount savings = new SavingsAccount(2222, 1000, 10);
		SavingsAccount savings2 = new SavingsAccount(2223, 1000, 10);
		ArrayList<String> log = new ArrayList<String>();

		// Test Interest Earning Logging Functionality
		savings.earnInterest();
		log.add("INTEREST: received 100.0 in profit from accruing interest.");
		assertEquals(log, savings.getTransactionLog());
		
		// Test Deposit Logging Functionality
		savings.deposit(250, "Virtual");
		log.add("DEPOSIT: received 250.");
		assertEquals(log, savings.getTransactionLog());
		
		// Test Transfer Logging Functionality
		savings.transfer(500, savings, savings2);
		log.add("TRANSFER: sent 500 to another account.");
		assertEquals(log, savings.getTransactionLog());
	}
	
	@Test
	void testInvestmentTransactionLog() {
		InvestmentAccount invest = new InvestmentAccount(3333, 1500);
		InvestmentAccount invest2 = new InvestmentAccount(3334, 1500);
		ArrayList<String> log = new ArrayList<String>();
		
		// Test Short Term Investment Functionality
		invest.shortInvest();
		log.add("INVEST: received 500 in profit from short term investment.");
		assertEquals(log, invest.getTransactionLog());
		
		// Test Long Term Investment Functionality
		invest.longInvest();
		log.add("INVEST: received 5000 in profit from long term investment.");
		assertEquals(log, invest.getTransactionLog());
		
		// Test Deposit Logging Functionality
		invest.deposit(250, "Virtual");
		log.add("DEPOSIT: received 250.");
		assertEquals(log, invest.getTransactionLog());
		
		// Test Transfer Logging Functionality
		invest.transfer(500, invest, invest2);
		log.add("TRANSFER: sent 500 to another account.");
		assertEquals(log, invest.getTransactionLog());
	}

}
