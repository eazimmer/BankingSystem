package code;
// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class BankAccountTest {

	public static void main(String[] args) {
		
		// Initialize Accounts
		CheckingAccount account1 = new CheckingAccount(1111, 100);
		SavingsAccount account2 = new SavingsAccount(2222,200,2);
		
		// Initialize Payment Methods
		DebitCard debitcard = new DebitCard(account1);
		CreditCard creditcard = new CreditCard(1000);
		Cash cash = new Cash(account1);
		
		// Initialize ATMs
		ATM targetATM = new ATM(account1, "Target");
		ATM walmartATM = new ATM(account1, "Walmart");
		ATM costcoATM = new ATM(account1, "Costco");
		ATM gasstationATM = new ATM(account2, "Gas Station");
		
		// Register ATMs with Bank Accounts
		account1.registerObserver(targetATM);
		account1.registerObserver(walmartATM);
		account1.registerObserver(costcoATM);
		account2.registerObserver(gasstationATM);

		
		// BankAccountTest
		System.out.println("A Checking Account has been created with ID: " + account1.getID() + "\n");
		System.out.print("Checking Account balance: ");
		account1.viewBalance();
		
		// Deposit funds from Target, see that changes are registered at the BankAccount
		targetATM.deposit(1000);
		System.out.print("\nChecking account balance: ");
		account1.viewBalance();
		
		// Withdraw more funds from Walmart after this ATM has received updates regarding BankAccount status
		walmartATM.withdraw(189, account1);
		
		// Access BankAccount balance from Costco ATM
		System.out.print("\n");
		costcoATM.viewBalance();
		
		// Transfer funds between accounts		
		System.out.println("\nA Savings Account has been created with ID: " + account2.getID());
		System.out.print("Savings Account balance: ");
		account2.viewBalance();
		gasstationATM.deposit(100);
		gasstationATM.viewBalance();
		System.out.print("\nBeginning funds transfer between accounts:\n");
		account1.transfer(100, account1, account2);
	
		// Example debit card payment deducting from affiliated account
		System.out.print("\n");
		debitcard.charge(100);
		targetATM.viewBalance();
		
		// Example cash payment from affiliated account
		System.out.print("\n");
		cash.charge(100);
		targetATM.viewBalance();
		
		// Example credit card payment accruing debt
		System.out.println("\nA Credit Card has been created with a credit limit of: $" + creditcard.getLimit());
		creditcard.viewDebt();
		creditcard.charge(100);
		creditcard.viewDebt();
		creditcard.charge(2000);
		creditcard.viewDebt();
		
		// Savings Account earning interest
		System.out.print("\nEarning interest on balance of Savings Account with ID: " + account2.getID() + "\n");
		gasstationATM.viewBalance();
		account2.earnInterest();
		gasstationATM.viewBalance();
	}
}