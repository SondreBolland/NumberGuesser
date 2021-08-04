package inf102.h21.guessers;

import java.util.Random;

import inf102.h21.main.RandomNumber;

/**
 * Guesses a random number between the lower and upper bound until the correct is found.
 * Checks if each guess is lower or higher than the correct number. Updates the bounds respectivly
 * and guesses only numbers within the new bounds.
 * 
 * @author Sondre Bolland
 *
 */
public class RandomGuesserUsingBounds implements IGuesser {
	
	private Random rand = new Random();

	@Override
	public int findNumber(RandomNumber number) {
		int lowerbound = number.getLowerbound();
		int upperbound = number.getUpperbound();
		
		int numberGuess = lowerbound;
		while (true) {
			int queryAnswer = number.guess(numberGuess);
			if (queryAnswer == 0)
				return numberGuess;
			else if (queryAnswer > 0)
				lowerbound = numberGuess;
			else
				upperbound = numberGuess;
			
			numberGuess = rand.nextInt(upperbound-lowerbound) + lowerbound;
		}	
	}

}
