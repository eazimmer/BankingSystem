package code;

public class Bitcoin implements PaymentMethods {

	private double coins;
	private final double CONVERSION_VALUE = 20000;
	
	// Overloaded Constructor
	public Bitcoin(double coins) {
		this.coins = coins;
	}
	
	@Override
	public void charge(int amount) {
		if ((amount <= (coins * CONVERSION_VALUE))) {
			coins -= amount / CONVERSION_VALUE;
			System.out.println("Succesfully spent $" + amount + " worth of Bitcoin. New coin wallet contains: " + coins + " coins.");
		}
		else { // Attempt to overdraw
			System.out.println("This transaction of $" + amount + " exceeded the wallet's current cash value of " + coins * CONVERSION_VALUE + ". Transaction cancelled.");
		}
	}
	
	
	public void chargeCoins(double amount) {
		if ((amount <= coins)) {
			coins -= amount;
			System.out.println("Succesfully spent " + amount + " worth of Bitcoin. New coin wallet contains: " + coins + " coins.");
		}
		else { // Attempt to overdraw
			System.out.println("This transaction of " + amount + " coins exceeded the wallet's value of " + coins + " coins. Transaction cancelled." );
		}
	}
	
	
	// Returns wallet's current value in coins
	public double getCoinBalance() {
		return coins;
	}
	
	
	// Returns wallet's current value in cash
	public double getCashBalance() {
		return coins * CONVERSION_VALUE;
	}
}
