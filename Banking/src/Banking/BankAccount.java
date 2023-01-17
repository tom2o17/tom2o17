package Banking;
/*
 * Represents a checking/savings bank account for a customer.
 */
public class BankAccount {
	
	// defining instance variables 
	
	// Type of account (checking or savings)
	String accountType;
	
	// Balance for the bank account.
	double balance;
	
	
	// Customer for this account.
	Customer customer;
	
	// All of the above variables can be different between different instances of bank accounts 
	
	// Constructors 
	/*
	 * Creates a bank account of a given type for a given customer 
	 * @param accountType for bank account 
	 * @param customer for bank account 
	 */
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType;
		this.customer = customer;
		
	}
	
	//methods 
	
	// Deposits the given amount.
	//@param amount to add to balance 
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	/*
	 * Withdraws the given amount from balance 
	 * @param amount to withdraw
	 * @throws excepetion if amount is > balance 
	 */
	
	public void withdraw(double amount) throws Exception {
		if (amount > this.balance) {
			throw new Exception("Amount is greater than available balance.");
		}
		this.balance -= amount;	
	}
	
	/*
	 * Returns account type and balance for this bank account 
	 * @return string with all the info 
	 */
	public String getAccountInfo() {
		return this.accountType + "; " + this.balance;
	}
	
	
	
	// Returns the customer name and address for a given bank account 
	//@return string with all info 
	public String getCustomerInfo() {
		return this.customer.getName() + " from " + this.customer.getAddress();
		
	}
	
}
