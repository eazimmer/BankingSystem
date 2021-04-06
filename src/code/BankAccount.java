package code;
// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

import java.util.ArrayList;

public abstract class BankAccount {
	// Using Strategy Pattern
	
	// Member Variables
	protected int accountID;
	protected int balance;
	public ArrayList<Observer> observers; // List of associated ATMs
	public ArrayList<String> transactions; // List of transaction events
	
	
	//  Default Constructor
	public BankAccount() {
		accountID = -1;
		balance = 0;
		observers = new ArrayList<Observer>();
		transactions = new ArrayList<String>();
	}
	
	
	// Overloaded Constructor
	public BankAccount(int accountId, int balance) {
		this.accountID = accountId;
		this.balance = balance;
		observers = new ArrayList<Observer>();
		transactions = new ArrayList<String>();
	}
	
	
	// Getter
	public int getID() {
		return accountID;
	}
	
	
	// Getter
	public int getBalance() {
		return balance;
	}
	
	
	// Setter
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	// Used to register an observer to be added to the update list
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	
	// Notifies all observers on the "mailing list" of BankAccount status
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(balance);
		}
	}
	
	
	// Deposits a designated sum of money
	public void deposit(int amount, String location) {
		balance += amount;
		this.logTransaction("DEPOSIT: received " + amount + ".");
		System.out.println("Deposit of $" + amount + " was successful from a " + location + " ATM to account with ID: " + accountID + "!");
		notifyObservers();
	}
	
	
	// View current account balance
	public void viewBalance() {
		System.out.println("$" + balance);
	}
	
	
	// Transfer money between accounts
	public void transfer(int amount, BankAccount account1, BankAccount account2) {
		if (amount <= account1.balance) { // Ensure valid request
			account1.balance -= amount;
			account2.balance += amount;
			account1.logTransaction("TRANSFER: sent " + amount + " to another account.");
			account2.logTransaction("TRANSFER: received " + amount + " from another account.");
			account1.notifyObservers();
			account2.notifyObservers();
			System.out.println("Transfer of $" + amount + " was successful:");
			System.out.println("Sender account, ID " + account1.getID() + ", new balance: $" + account1.getBalance());
			System.out.println("Receiver account, ID " + account2.getID() + ", new balance: $" + account2.getBalance());
		}
		else { // Attempt to overdraw
			System.out.println("Insufficient funds in sender account to perform a funds transfer. Transaction cancelled.");
		}
	}
	
	
	// Returns current transaction log
	public ArrayList<String> getTransactionLog() {
		return transactions;
	}
	
	
	// Add to transaction log 
	public void logTransaction(String content) {
		this.transactions.add(content);
	}
}
