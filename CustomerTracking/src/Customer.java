import java.util.ArrayList;

/*
 * Represent a customer with name, ID, and geography.
 */

public class Customer {
	
	//  Static Variables 
	// Shared across all instances of Customer
	
	/*
	 * Company for all customers.
	 */
	static final String COMPANY = "CVS";
	
	
	/*
	 * Store list of all customers.
	 */
	static ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();
	
	/*
	 * To generate and keep track of customer IDs.
	 */
	static Counter COUNTER;
	
	// instance variables 
	
	/*
	 * Name of customer 
	 */
	String name;
	
	/*
	 * Geography of customer
	 */
	String geography;
	
	/*
	 * ID of customer 
	 */
	int ID;
	
	// constructor 
	public Customer(String name, String geography) {
		this.name = name;
		this.geography = geography;
		
		// get unique ID from counter 
		this.ID = Customer.COUNTER.getCount();
		
		// increment counter 
		Customer.COUNTER.increment();
		
		// add this customer to the list of all customers
		Customer.CUSTOMERS.add(this);
	}
	
	// method for printing all the customers 
	
	/*
	 * Prints all customer for the company
	 */
	public static void printAllCustomers() {
		System.out.println("All customers:");
		
		// iterate over statically generated references list of customers
		for (Customer c: Customer.CUSTOMERS) {
			System.out.println(c);
		}
		System.out.println();
		System.out.println();
	}
	
	
	/* Compares two customers for equality.
	 * If they have the same name and geography, they are equal 
	 */
	
	public boolean equals(Object obj) {
		
		// Cast object to customer
		Customer otherCustomer = (Customer) obj;
		
		
		if ((this.name.equals(otherCustomer.name) && 
				(this.geography.equals(otherCustomer.geography)))) {
			return true;
		}
		return false;
		
	}
	
	/*
	 * This returns the ID, name of customer, and geography 
	 */
	
	public String toString() {
		return this.ID + ": " + this.name + ", Company: " + Customer.COMPANY + ", Location: "
				+ this.geography;
	}
	
	
	/**
	 * Locates the given customer in the list of customers.
	 * @param customer to loop up
	 * @return index of given customer in list, otherwise -1
	 */
	public static int findCustomer(Customer customer) {
		
		// Set default index 
		int index = -1;
		
		// iterate over customer list and locate given customer
		for (int i = 0; i <Customer.CUSTOMERS.size(); i++) {
			if (Customer.CUSTOMERS.get(i).equals(customer)) { // This will call equals method customer class 
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	
	/**
	 * Removes the given customer from list of customers
	 * @param customer to remove
	 */
	public static void removeCustomer(Customer customer) {
		// find the customer
		int removeIndex = Customer.findCustomer(customer);
		
		// check if index is valid then remove customer
		if (removeIndex >= 0) {
			Customer.CUSTOMERS.remove(removeIndex);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		// initializing static variable counter
		// initialize the counter for generating unique IDs for each customer
		Customer.COUNTER = new Counter(1);
		
		// create customer 
		Customer c1 = new Customer("Thomas", "Alexandria VA");
		Customer.printAllCustomers();
		
		
		Customer c2 = new Customer("Theo", "NJ");
		Customer.printAllCustomers();
		
		// print all customers 
		Customer c3 = new Customer("John Doe", "NV");
		Customer.printAllCustomers();
		
		Customer.removeCustomer(c2);
		Customer.printAllCustomers();
		
	}

}
