package Banking;
/*
 * Represents a customer of a bank 
 */
public class Customer {
	// instance variables 
	
	// name of customer 
	String name;
	
	// address of customer 
	String address;
	
	// Constructor 
	
	// Creates a customer with a given name 
	// @param: name of customer 
	public Customer(String name) {
		// Sets instance var name to given name 
		this.name = name;
	}
	
	// methods
	/*
	 * Sets the address of customer to be given address.
	 * @param adress for customer 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	/*
	 * Returns the customers name 
	 * @retrun name of customer 
	 */
	public String getName() {
		return this.name;
	}
	
	
	// Returns customers address 
	//@return address of customer 
	public String getAddress() {
		return this.address;
	}
	


}
