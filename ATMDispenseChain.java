// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

public class ATMDispenseChain {
	// Utilizing Chain of Responsibility Pattern

	public DispenseChain c1;

	public ATMDispenseChain() {
		
		// Initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();
		DispenseChain c4 = new Dollar5Dispenser();
		DispenseChain c5 = new Dollar1Dispenser();

		// Create the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
		c3.setNextChain(c4);
		c4.setNextChain(c5);
	}
}