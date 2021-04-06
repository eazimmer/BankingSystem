package code;
// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class ATM extends Observer {

	// Member Variables
	private BankAccount account; // Purely for executing deposits and withdraws
	private double balance; // ATM receives balance information from BankAccount notifications, Observer Pattern
	private String location;
	
	
	// Overloaded Constructor
	public ATM(BankAccount account, String location) {
		this.account = account;
		this.location = location;
	}
	
	
	// Implementation of abstract method used to receive updates
	@Override
	public void update(double balance) {
		this.balance = balance;
	}
	
	
	// View current account balance
	public void viewBalance() {
		System.out.println("Current account balance of account " + account.getID() + ": $" + balance + ". Accessed from a " + location + " ATM.");
	}
	
	
	// Add money to account
	public void deposit(int amount) {
		account.deposit(amount, location);
	}
	
	
	// Withdraw money from account
	public void withdraw(int amount, CheckingAccount acc) {
		acc.withdraw(amount, location);
	}
}
