package inf102.h21.guessers;

import java.util.HashSet;
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
	private HashSet<Integer> guessedNumbers = new HashSet<>();
	
	@Override
	public int findNumber(RandomNumber number) {
		int lowerbound = number.getLowerbound();
		int upperbound = number.getUpperbound();
		int numberGuess = lowerbound;
		guessedNumbers.add(numberGuess);
		
		while (number.guess(numberGuess) != 0) {
			// Guess a random number until one that has not been guessed before is selected
			while (guessedNumbers.contains(numberGuess)) {
				numberGuess = rand.nextInt(upperbound-lowerbound) + lowerbound;
			}
			guessedNumbers.add(numberGuess);
		}
		guessedNumbers.clear();
		return numberGuess;
	}

}
