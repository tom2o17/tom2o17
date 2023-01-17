package counter_demo;



public class Counter {
	
	
	// Instance variables 
	
	// Stores internal count 
	// Defaults to 0. 
	int count = 0;
	
	
	// methods 
	
	
	/*
	 * Increments internal count.
	 * @return new value of internal count 
	 */
	public int increment() {
		this.count += 1;
		return this.count;
	}
	
	
	
	/*
	 * decrements internal count 
	 * @return new value of internal count 
	 */
	
	public int decrement() {
		this.count -= 1;
		return this.count;
	}

	
	/*
	 * @ returns the current value of the internal count.
	 */
	public int getCount() {
		return this.count;
		
	}
}

