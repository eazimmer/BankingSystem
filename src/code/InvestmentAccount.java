package code;

public class InvestmentAccount extends BankAccount{

	// Overloaded Constructor
	public InvestmentAccount(int accountId, int balance) {
        super(accountId, balance);
    }
	
	// Invest with priority of profits over long term
	public void longInvest() {
		System.out.println("Investment account with ID: " + accountID + " earned $5000 after a long term investment. The new account balance is: " + balance);
		balance = (int) (balance + 5000);
		this.logTransaction("INVEST: received " + 5000 + " in profit from long term investment.");
		notifyObservers();
		
	}
	
	// Invest with priority of profits over short term
	public void shortInvest() {
		System.out.println("Investment account with ID: " + accountID + " earned $500 after a short term investment. The new account balance is: " + balance);
		balance = (int) (balance + 500);
		this.logTransaction("INVEST: received " + 500 + " in profit from short term investment.");
		notifyObservers();
	}

}