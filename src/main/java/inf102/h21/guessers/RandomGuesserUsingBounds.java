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
	private int lowerbound;
	private int upperbound;

	@Override
	public int findNumber(RandomNumber number) {
		lowerbound = number.getLowerbound();
		upperbound = number.getUpperbound();
		
		while (lowerbound<upperbound) {
			int nextGuess = makeGuess();
			int queryAnswer = number.guess(nextGuess);
			if(updateBounds(nextGuess, queryAnswer))
				return nextGuess;			
		}
		
		return lowerbound;		
	}

	private int makeGuess() {
		return rand.nextInt(upperbound-lowerbound) + lowerbound;
	}

	/**
	 * Updates bounds depending whether guess was lower or higher
	 * @param numberGuess
	 * @param queryAnswer
	 * @return
	 */
	private boolean updateBounds(int numberGuess, int queryAnswer) {
		if (queryAnswer == 0) {
			lowerbound = numberGuess;
			upperbound = numberGuess;
			return true;
		}
		else{ 
			if (queryAnswer > 0) {
				lowerbound = numberGuess+1;
			}
			else {
				upperbound = numberGuess-1;
			}
			return false;
		}
	}
}
