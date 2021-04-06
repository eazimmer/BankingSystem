package code;
// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class SavingsAccount extends BankAccount{
	
	private int interestpercentage;
	
	// Default Constructor
	public SavingsAccount(int accountId, int balance, int percent) {
        super(accountId, balance);
        this.interestpercentage = percent;
    }
	
	
	// Get current interest rate
	public int getInterestRate() {
		return interestpercentage;
	}
	
	
	// Earn interest on account balance
	public void earnInterest() {
		double interest = (interestpercentage * balance)/100;
		System.out.println("Savings account with ID: " + accountID + " has earned " + interestpercentage + "% interest on their account with a balance of $" + balance);
		balance = (int) (balance + interest);
		this.logTransaction("INTEREST: received " + interest + " in profit from accruing interest.");
		notifyObservers();
	}
}
