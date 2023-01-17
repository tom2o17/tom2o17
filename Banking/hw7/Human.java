package hw7;

import java.util.Random;
import java.util.Scanner;

public class Human {
	
	/**
	 * The name of the player
	 */
	private String name;
	
	/**
	 * The score of the current player
	 */
	private int score = 0;
	
	
	/**
	 * Constructs a human player with the given name
	 * @param name of human
	 */
	public Human(String name) {
		this.name = name;
	}

	/**
	 * Controls human player to roll the dice, and prints the related information for each roll.
	 * First of all, this method will automatically roll one time for the human player, 
	 * if the result is 6, the player will have no right to roll again and this method should return 0; 
	 * else, this roll will be added to the total score for this turn.
	 * User should answer Y or N (y or n) to determine whether they want to roll the dice again or stop with the current score.
	 * This method will also update the human's total score.
	 * @param computer player
	 * @param random number generator
	 * @param sc to get input from user
	 * @return the score this round (for example, 
	 * 1. the player rolls: 2, 6, then this method should return 0
	 * 2. the player rolls: 5, 5, 2, then this method should return 12
	 * )
	 */
	public int move(Computer computer, Random random, Scanner sc) {
		// Sets the user's initial points for this turn = 0 
		int points = 0; 
		// Initializes a boolean variable to allow for flow control 
		boolean flow = true;
		// A while loop is then entered
		while (flow == true) {
			// This function will return a random int [0:5]
			int x = random.nextInt(6);
			// 'x' is then incremented by 1 so that we now have a random int [1:6]
			x += 1;
			// The user is then notified of the number that he has rolled 
			System.out.println( this.name + "'s roll: " + x);
			// if the user has rolled a '6':
			if (x == 6) {
				// the 'flow' variable is set to false, so the user will not be able to roll again 
				flow = false;
				// The user's points for this turn are set to 0 
				points = 0; 
			// Else if the user rolls anything besides a 6:
			} else if (x < 6 && flow == true) {
				// The user's points are then incremented by the value of 'x'
				points += x;
				
				
				// The user is then asked if he would like to roll again 
				System.out.println( "Would you like to roll again?");
				String again = sc.next();
				char r = again.charAt(0);
				// if the user's response begins with 'y', nothing happens and the while loop 
				// will be iterated over again (allowing the user to roll)
				if (r == 'Y' | r == 'y') {
				// Else if the user's response begins with 'n' then the loop will break and the 
				// function will return the user's current score 
				} else if (r == 'n' | r == 'N'){ 
					break;
				}
			}
		}
		// The user is notified of his score for this round 
		System.out.println(this.name + " score for this round is: " + points);
		// The function will then return the user's score for this turn.
		return points; 
	}

	
	/**
	 * Get the name of human
	 * @return name
	 */
	public String getName() {
		return this.name; 
	}

	/**
	 * Get the score of human
	 * @return score
	 */
	public int getScore() {
		return this.score; 
	}
	
	/**
	 * Set the score of human
	 * @param score
	 */
	public void setScore(int score) {
		// increments the score of the human 
		this.score += score;
		// This function does not return a value.
	}
	
}


