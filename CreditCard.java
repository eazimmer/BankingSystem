// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class CreditCard implements PaymentMethods {
	
	private int debt = 0;
	private int creditLimit;

	// Overloaded Constructor
	public CreditCard(int creditlimit1) {
		creditLimit = creditlimit1;
	}
	
	
	// Getter
	public double getLimit() {
		return creditLimit;
	}
	
	
	// Charge credit card
	@Override
	public void charge(int amount) {
		if ((amount + debt)<= creditLimit) {
			debt += amount;
			System.out.println("Succesfully charged $" + amount + " using credit card.");
		}
		else { // Attempt to overdraw
			System.out.println("Attempted to exceed credit limit of $" + creditLimit + " with purchase of $" + amount + "; transaction cancelled.");
		}
	}
	
	
	// View debt on card
	public void viewDebt() {
		System.out.println("Debt owed on credit card: $" + debt);
	}
}
