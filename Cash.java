// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class Cash implements PaymentMethods{
	
	private BankAccount account;
	protected ATMDispenseChain atmDispenser = new ATMDispenseChain(); // Object to handle withdraw of currency
	
	// Default Constructor
	public Cash() {
		account = null;
	}
	
	
	// Overloaded Constructor
	public Cash(BankAccount account) {
		this.account = account;
	}
	
	
	// Make a payment using cash
	@Override
	public void charge(int amount) {
		System.out.println("Paying $" + amount + " in cash from account ID: " + account.getID());
		account.setBalance(account.getBalance()-amount);
		account.notifyObservers();
		atmDispenser.c1.dispense(new Currency(amount));
	}
}
