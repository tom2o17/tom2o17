package hw7;

import java.util.Random;

public class Computer {
	
	/**
	 * The score of the computer
	 */
	private int score = 0;
	
	/**
	 * Controls computer player to roll the dice, and prints the related information for each roll
	 * First of all, this method will automatically roll one time for the computer player, 
	 * if the result is 6, the computer will have no right to roll and this method should return 0; 
	 * else, this roll will be added to the total score for this turn.
	 * The computer should play intelligently to determine whether they want to roll the dice again or stop with the current score.
	 * It depends on you how to design the strategy for the computer.
	 * This method will also update the computer's total score.
	 * @param human player
	 * @param random number generator
	 * @return the score this round (for example, 
	 * 1. the computer rolls: 2, 6, then this method should return 0;
	 * 2. the computer rolls: 5, 5, 2, then this method should return 12;
	 * )
	 */
	public int move(Human human, Random random) {
		// initializes a boolean variable to allow for flow control 
		boolean flow = true;
		// sets the computer's score to 0 for this turn 
		int score = 0;
		// While loop allows the computer to elect to roll again 
		while (flow == true) {
			// Casts a random int [0:5] to a variable 'x'
			int x = random.nextInt(6);
			// The variable 'x' is then incremented by '1' so that we now have [1:6] 
			x += 1;
			// If the dice roll is not 8 and the computers score for this turn is < 10 
			if (x < 6 && score < 10) {
				// The user is notified of the computer's roll 
				System.out.println("The Computer rolled: "+ x);
				// This roll is then incremented to the computer's score 
				score += x; 
			
			// Else if the computer has scored more than ten points during this turn then:	
			} else if (score >= 10) {
				System.out.println();
				// The human user is notified that the computer has elected not to roll again 
				System.out.println("The Computer has elected not to roll again");
				System.out.println();
				// The 'flow' variable is then set to false and the while loop will not be iterated 
				// over again 
				flow = false;
			// Else if the dice roll returns a 6:
			} else if(x == 6) {
				// The user is notified that the computer has rolled a '6'
				System.out.println("The Computer rolled: "+ x);
				// The 'flow' variable is then set to false and the while loop will not be iterated 
				// over again 
				flow = false;
				// The computer's score is then set to 0 
				score = 0;
			} 
		}
		// The user is then notified of the computer's score for this round 
		System.out.println("The computer's score for this round is: " + score);
		return score; 
	}
	/**
	 * Get the score of computer
	 * @return score
	 */
	public int getScore() {
		// Returns the score from the computer's class 
		return this.score;

	}
	
	/**
	 * Set the score of computer
	 * @param score
	 */
	public void setScore(int score) {
		// increments the score of a given instance in the computer's class.
		this.score += score;
		

	}
}
