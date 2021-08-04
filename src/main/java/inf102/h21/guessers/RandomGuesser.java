package inf102.h21.guessers;

import java.util.Random;

import inf102.h21.main.RandomNumber;

/**
 * Guesses a random number between the lower and upper bound until the correct is found.
 * @author Sondre Bolland
 *
 */
public class RandomGuesser implements IGuesser {

	private Random rand = new Random();
	
	@Override
	public int findNumber(RandomNumber number) {
		int lowerbound = number.getLowerbound();
		int upperbound = number.getUpperbound();
		
		int numberGuess = lowerbound;
		while (number.guess(numberGuess) != 0) {
			numberGuess = rand.nextInt(upperbound-lowerbound) + lowerbound;
		}	
		return numberGuess;
	}

}
