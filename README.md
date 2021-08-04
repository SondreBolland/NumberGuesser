# Number Guessing Game
Given a randomly generated number between ``0`` and ``n`` you are to guess the number by any algorithmic means.

The ``RandomNumber`` class generates a random number given a lower and upper bound. This number is hidden within the class.
The method ``RandomNumber::guess`` is a query method which you use to guess a number. The method returns:
 * 0 if the guess is correct
 * -1 if the guess was too low
 * 1 if the guess was too high
For every guess you make the count of total guesses increments. 

## Task
Implement a Guesser class which uses fewer guesses than the exisitng guesser classes. 
```java
public class MyGeniousGuesser implements IGuesser {
  ...
 }
 ```
 The interface ``IGuesser`` contains one method ``findNumber`` which must return the correct number (throws an exception if wrong number).
 
 Remember to add your guesser to the list of guessers in ``Main::main``.
 
 ## Expected output:
 ```
Correct number: 63335

After 1000 guessing games the guessers got the following average guessing counts:
MyGeniousGuesser:                      ?  guesses
RandomGuesserUsingBounds:             23  guesses
RandomGuesserWithMemory:          48 725  guesses
RandomGuesser:                    99 318  guesses
SequentialGuesser:                63 336  guesses
```

