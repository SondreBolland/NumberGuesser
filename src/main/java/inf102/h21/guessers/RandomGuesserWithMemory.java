package inf102.h21.guessers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import inf102.h21.main.RandomNumber;

/**
 * Guesses a random number between the lower and upper bound until the correct is found.
 * Remembers already guessed numbers and does not guess these more than once.
 * @author Sondre Bolland
 *
 */
public class RandomGuesserWithMemory implements IGuesser {

	private Random rand = new Random();
	
	@Override
	public int findNumber(RandomNumber number) {
		int lowerbound = number.getLowerbound();
		int upperbound = number.getUpperbound();
		
		// List of all integers in bound (possible guesses)
		List<Integer> allIntegersInBound = new ArrayList<>();
		for (int i = lowerbound; i < upperbound; i++) {
			allIntegersInBound.add(i);
		}
		
		// Guess randomly until correct, but never same number
		int nextGuess = lowerbound;
		do {
			nextGuess = getRandomNumber(allIntegersInBound);
		} while (number.guess(nextGuess) != 0);

		return nextGuess;
	}
	
	/**
	 * Picks a random number from list. Number is removed from the list
	 * @param integers list of integers
	 * @return random number from list
	 */
	public int getRandomNumber(List<Integer> integers) {
		int randIndex;
		int upperbound = integers.size()-1;
		if (upperbound == 0)
			randIndex = 0;
		else
			randIndex = rand.nextInt(upperbound);
		
		int nextGuess = integers.remove(randIndex);
		return nextGuess;
	}

}
