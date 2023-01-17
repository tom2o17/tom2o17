package hw7;

import java.util.Random;

import java.util.Scanner;

public class GameControl {

	/**
	 * Computer player
	 */
	Computer computer;
	
	/**
	 * Human player
	 */
	Human human;
	
	/**
	 * A random number generator to be used for returning random dice result (1-6) for both computer and human player
	 */
	Random random = new Random();

	
	/**
	 * The main method just creates a GameControl object and calls its run method
	 * @param args not used
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Welcome to Pig!");
		
		GameControl gc = new GameControl();
		while (true) {
			gc.run(sc);
			System.out.println("--------------------");
			System.out.println("Do you want to play again?");
			
			boolean check = gc.askYesNo(sc);
			if (!check) {
				System.out.println("Goodbye!");
				sc.close();
				break;
			}
		}
	}
	
	/**
     * Calls methods to perform each of the following actions:
     * - Ask user to input the name for human player, and print welcome with the name
     * - Create the players (one human and one computer)
     * - Control the play of the game
     * - Print the final results
	 * @param sc to use for getting user input
	 */
	public void run(Scanner sc) {
		
		// Prints user interface into the console 
		System.out.println();
		System.out.println("Greetings player!");
		System.out.println("What is your name?");
		// Prompts the user for their input 
		String humanName = sc.next();
		// Greets the user 
		System.out.println("Grettings " + humanName + " let's play pig!");
		
		// Creates an entry in the human class, by calling the 'createPlayers()' function 
		createPlayers(humanName);

		// Creates a while loop that is iterated over so long as the 'checkWinningStatus()' 
		// function returns false.
		while (checkWinningStatus() != true) {
			
			// Calls the 'computer.move()' function and stores the result in a local variable 'x'.
			int x = computer.move(human, random);
			// increments the computer's score by the value 'x'.
			computer.setScore(x);
			
			// Prints a message to the user regarding the computer's score. 
			System.out.println("Computer's total score is: " + computer.getScore());
			System.out.println();
			
			// Calls the 'computer.move()' function and stores its output in a local variable 'y'.
			int y = human.move(computer, random, sc);
			// increments the user's score by the value of 'y'.
			human.setScore(y);
			
			// Prints a message into the console notifying the user of his total score 
			// as well as a bar that allows the user to know one full turn iteration has passed. 
			System.out.println( human.getName() + "'s total score is: " + human.getScore());
			System.out.println("_________________________");
			System.out.println();
		}
		// When this while loop is exited, one of the player's has won the game 
		// 'printResults()' function and 'printWinner()' function are then called 
		// and the relevant information is then printed out to the user.
		printResults();
		printWinner();
	}

	
	
	/**
     * Creates one human player with the given humanName, and one computer player with a name.
     * @param humanName for human player
     */
	public void createPlayers(String humanName) {
		// Creates an new entry in the Human class with the name of the variable that is handed to 
		// the function.
		 this.human = new Human(humanName);
		 // creates an new entry in the Computer class with the name "Computer" 
		 this.computer = new Computer();
		 
	}
	
	/**
     * Checks if a winning status has been achieved
     * @return true if one player has won the game
     */
	public boolean checkWinningStatus() {
		// creates two boolean variables which are set to false by default.
		// The first variable 'bool' is the variable that is returned by the 
		// function.
		// The second variable allows the function to return false in the event that there 
		// is a tie. 
		boolean bool = false; 
		boolean tie = false;
		
		// in the case of a tie, the tie variable is set to true and the 'bool' variable 
		// remains false.
		if (this.computer.getScore() == this.human.getScore()) {
			tie = true;
		}
		// These two else if statements then will change the value of the 'bool' variable 
		// provided that one of the players has a score >= 50. 
		else if (this.computer.getScore() >= 50 && tie == false) {
			bool = true; 
		} else if (this.human.getScore() >= 50 && tie == false) {
			bool = true;
		} 
		// The 'bool' variable is then returned from the call to the function. 
		return bool; 
	}
	
	/**
	 * Prints the final scores of the human player and computer player
	 */
	public void printResults() {
		// Prints the results of the game to the user including a blank line in order to make 
		// the spacing more appealing to the user 
		System.out.println();
		System.out.println("The Final Results of the game of pig are: ------ ");
		// notifies the user of both his score and the computer's
		System.out.println("The Computer's final score is: " + this.computer.getScore());
		System.out.println(human.getName() + "'s final score is: " + this.human.getScore());
	
	}
	
	/**
     * Determines who won the game, and prints the results
     * 
     */
	public void printWinner() {
		// If statement to determine if the user has more points than the computer   
		if (this.human.getScore() >= this.computer.getScore()) {
			// Stores the users name in a variable named 'result'
			String result   = this.human.getName();
			System.out.println();
			// Prints a statement that lets the user know that he has won the game 
			System.out.println(result + " is the winner of this game!");
		// If statement to check to see if the computer has won the game 
		} else if (this.computer.getScore() >= this.human.getScore()) {
			System.out.println();
			// Prints a message letting the user know that the computer has won
			System.out.println("The Computer is the winner of this game!");
		}
	}
	
	/**
	 * If the user responds with a string "y" or "Y", the function returns True. 
	 * If the  user responds with a string "n" or "N", the function returns False. 
	 * Any other response will cause the question to be repeated until the user provides an acceptable response. 
	 * @param sc to use for getting user input
	 */
	public boolean askYesNo(Scanner sc) {
		boolean result = false;
		// Creates a string variable to hold the response 
		String resp = sc.next();
		// casts the first character in the string into a variable 'r' 
		char r = resp.charAt(0);
		// checks to see if the character is a 'Y' or 'y' and will return 'true' 
		if (r == 'Y' | r == 'y') {
			result = true;
		// Checks to see if the character at index position 0 is 'N' or 'n' and will return 'false'
		} else if (r=='N'|r=='n') {
			result = false;	
		}
		return result;
	}
	
}
