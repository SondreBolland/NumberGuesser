package inf102.h21.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import inf102.h21.guessers.BinaryGuesser;
import inf102.h21.guessers.IGuesser;
import inf102.h21.guessers.RandomGuesser;
import inf102.h21.guessers.RandomGuesserUsingBounds;
import inf102.h21.guessers.RandomGuesserWithMemory;
import inf102.h21.guessers.SequentialGuesser;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		final int lowerbound = 0;
		final int upperbound = 100000; // 100 000
		RandomNumber number = new RandomNumber(lowerbound, upperbound);
		
		// Guessers
		List<IGuesser> guessers = Arrays.asList(new RandomGuesser(), new RandomGuesserWithMemory(),
				new SequentialGuesser(), new BinaryGuesser(),
				new RandomGuesserUsingBounds() /* TODO: add guesser */);
		Map<IGuesser, Integer> guessCounts = new HashMap<>();
		for (IGuesser guesser: guessers)
			guessCounts.put(guesser, 0);
		
		// Run n games
		int nGames = 1000;
		for (int i = 0; i < nGames; i++) {
			runGuessingGame(guessers, number, guessCounts);
		}
		
		// Print results
		System.out.printf("%nAfter %d guessing games the guessers got the following"
				+ " average guessing counts:%n", nGames);
		for (IGuesser guesser: guessCounts.keySet()) {
			printResult(guesser, guessCounts.get(guesser), nGames);
		}
	}
	
	/**
	 * Plays the guessing game <code>nGames</code> times
	 *  and tallies up the total number of guesses made by each guesser.
	 * 
	 * @param nGames number of guessing games to be played
	 * @param guessers list of guessers participating in the guessing game
	 * @param number number object to be guessed
	 * @param guessCounts map of total guess counts per guesser
	 */
	public static void runGuessingGame(List<IGuesser> guessers,
			RandomNumber number, Map<IGuesser, Integer> guessCounts) {
		
		for (IGuesser guesser: guessers) {
			int guessCount = guessNumber(guesser, number);
			guessCounts.put(guesser, guessCounts.get(guesser) + guessCount);
		}
	}
	/**
	 * The given guesser guesses a number until the correct is found
	 * @param guesser
	 * @param randomNumber
	 * @return total number of guesses
	 */
	public static int guessNumber(IGuesser guesser, RandomNumber number) {
		int guessedNumber = guesser.findNumber(number);
		if (number.guess(guessedNumber) != 0)
			throw new IllegalStateException("The guessed number is not correct");
		
		int guessCount = number.getGuessCount()-1;
		number.resetGuessCount();
		return guessCount;
	}
	
	/**
	 * Prints how many guesses the given guesser used to correctly guess the number
	 * @param guesser
	 * @param guessCount
	 */
	public static void printResult(IGuesser guesser, int guessCount, int nGames) {
		String guesserName = guesser.getClass().getSimpleName();
		DecimalFormat formatter = new DecimalFormat("#, ###");
		String formattedCount = formatter.format(guessCount/nGames);
		System.out.printf("%-25s %15s guesses%n", guesserName+":", formattedCount);
	}
}
