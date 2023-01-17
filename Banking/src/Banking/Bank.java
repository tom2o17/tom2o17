package Banking;

import java.util.Scanner;

/*
 * Represents a bank for managing customers and their bank accounts 
 * @author tclement
 */
public class Bank {

	public static void main(String[] args) {
		//Creates new instance of the bank class 
		Bank bank = new Bank();
		
		//Calls the run method in the bank class 
		bank.run();
		

	}
	
	/*
	 * Runs the program by initializing and managing, bank accounts, and customers.
	 */
	public void run() {
		System.out.println("Welcome to the Thomas Clement's Bank! What is your name?");
		
		// Create scanner to get user input 
		Scanner scanner = new Scanner(System.in);
		
		// Get the next token (word), which is the customer's name
		String name = scanner.next();
		
		System.out.println("Hello " + name + "! We are creating checking and savings accounts for you.");
		
		
		// Create customer with given name 
		Customer customer = new Customer(name);
		
		// get address 
		System.out.println("What is your address?");
		
		//get the next token (word), which is the customer's address 
		String address = scanner.next();
		
		// Set the customer's address 
		customer.setAddress(address);
		
		
		// Create a checking account for given customer 
		BankAccount checkingAccount = new BankAccount("checking", customer);
		
		//Create a savings account for the same customer
		BankAccount savingsAccount = new BankAccount("savings", customer);
		
		// gets and prints the customer info associated with the checking account 
		System.out.println();
		System.out.println("Customer info: ");

		System.out.println(savingsAccount.getCustomerInfo());
		
		
		// get and print account info for checking / savings account  account 
		System.out.println("Checking account: ");
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println("Savings account: ");
		System.out.println(savingsAccount.getAccountInfo());
		
		//Deposits 
		
		// into checking 
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your checking account?");
		double amount = scanner.nextDouble();
		checkingAccount.deposit(amount);
		
		// into savings 
		System.out.println(); // blank line 
		System.out.println("Amount (decimal) to deposit into your savings account?");
		amount = scanner.nextDouble();
		savingsAccount.deposit(amount);
		
		// Print new balances 
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		
		
		// Withdrawls 
		
		// from checking 
		System.out.println();
		System.out.println("Amount (decimal) to withdraw from your checking account?");
		amount = scanner.nextDouble();
		
		try {
			checkingAccount.withdraw(amount); // withdraw from checking 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// From savings 
		System.out.println();
		System.out.println("Amount (decimal) to withdraw from your savings account?");
		amount = scanner.nextDouble();
		
		try {
			savingsAccount.withdraw(amount); // withdraw from savings
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		// Print new balances 
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		scanner.close();	
	}
}
