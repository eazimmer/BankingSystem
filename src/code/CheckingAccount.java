package code;
// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class CheckingAccount extends BankAccount{
	
	protected ATMDispenseChain atmDispenser = new ATMDispenseChain(); // Object to handle withdraw of currency
	
	// Overloaded Constructor
	public CheckingAccount(int accountId, int balance) {
        super(accountId, balance); 
    }
	
	
	// Withdraws a designated sum of money - employs Chain of Responsibility pattern
	public void withdraw(int amount, String location) {
		if (amount <= balance) { // Ensure valid withdraw request
			balance -= amount;
			System.out.println("Withdraw request of $" + amount + " successfully received from a " + location + " ATM!\n");
			notifyObservers();
			atmDispenser.c1.dispense(new Currency(amount));
		}
		else { // Attempt to overdraw
			System.out.println("An error occurred during the withdraw. User attempted to overdraft the account. Request cancelled.\n");
		}
	}
}
