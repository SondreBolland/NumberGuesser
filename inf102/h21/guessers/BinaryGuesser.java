package inf102.h21.guessers;

import java.util.Random;

import inf102.h21.main.RandomNumber;

/**
 * Guesses the number by use of binary search.
 * 
 * @author Sondre Bolland
 *
 */
public class BinaryGuesser implements IGuesser {

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
		return (upperbound+lowerbound) / 2;
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
