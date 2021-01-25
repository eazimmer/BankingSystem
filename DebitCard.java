// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class DebitCard implements PaymentMethods{
	
	CheckingAccount account;
	
	// Default Constructor
	public DebitCard(CheckingAccount account1) {
		account = account1;
	}
	
	// Charge debit card; spend money from bank account
	@Override
	public void charge(int amount) {
		if (amount <= account.balance) {
			account.balance -= amount;
			System.out.println("Succesfully charged $" + amount + " using debit card affiliated with account ID: " + account.getID());
			account.notifyObservers();
		}
		
		else { // Attempt to overdraw
			System.out.println("Attempted to overdraw, transaction cancelled.");
		}
	}
}
