package inf102.h21.guessers;

import inf102.h21.main.RandomNumber;

/**
 * Guesses the number by use of binary search.
 * 
 * @author Sondre Bolland
 *
 */
public class BinaryGuesser implements IGuesser {

	@Override
	public int findNumber(RandomNumber number) {
		int lowerbound = number.getLowerbound();
		int upperbound = number.getUpperbound();
		int foundNumber = binarySearch(number, lowerbound, upperbound);
		return foundNumber;
	}
	
	public int binarySearch(RandomNumber number, int left, int right) {
		if (left > right)
			throw new IllegalArgumentException("The lowerbound cannot be lower than the upperbound.");
		
		int mid = (left + right) / 2;
		int comparison = number.guess(mid);
		if (comparison == 0)
			return mid;
		else if (comparison < 0)
			return binarySearch(number, left, mid-1);
		else
			return binarySearch(number, mid+1, right);
	}
	

}
