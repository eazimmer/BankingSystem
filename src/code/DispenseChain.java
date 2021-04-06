package code;
// Eric Zimmer, Laurence Madsen
// eric.zimmer@mymail.champlain.edu, laurence.madsen@mymail.champlain.edu
// Final Project

// Interface for CoR pipeline
public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void dispense(Currency cur);
}