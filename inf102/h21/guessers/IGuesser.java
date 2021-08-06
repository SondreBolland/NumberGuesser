package inf102.h21.guessers;

import inf102.h21.main.RandomNumber;

/**
 * Interface for number guessers.
 * A guesser must find a randomly generated number by querying a <code>RandomNumber</code> object.
 * 
 * @author Sondre Bolland
 *
 */
public interface IGuesser {
	
	/**
	 * Finds the number by querying <code>number</code>
	 * Must return the correct number!
	 * 
	 * @param number
	 * @return the correct number
	 */
	public int findNumber(RandomNumber number);
	
}
