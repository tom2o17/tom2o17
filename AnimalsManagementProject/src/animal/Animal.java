package animal;

/**
 * Representsd a generic Animal 
 * We will create subclasses (dog, cat, maybe others) that will inherit from this class
 * @author Thoma
 *
 */


public class Animal {
	
	// Static Variables 
	
	/**
	 * Default age for animal 
	 */
	static int DEFAULT_AGE = 0;
	
	// Instance variables 
	/**
	 *  Age of animal 
	 */
	int age;
	
	/*
	 * Weight of animal 
	 */
	double weight;
	
	
	/**
	 *  The name of an animal 
	 */
	String name;
	
	// constructors
	
	/**
	 * This creates an animal with given age 
	 * @param age
	 */
	public Animal(int age) {
		this.age = age;
	}
	
	
	/**
	 * Creates an animal with default age 
	 */
	public Animal() {
		// calls first constructor with default age value 
		this(Animal.DEFAULT_AGE);
	}

	
	// getters/setters
	
	/**
	 * Gets the name of the animal 
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name of the animal 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	// other methods 
	
	/**
	 * Animal speaks 
	 */
	public void speak() {
		System.out.println("Animal says: Hi!");
	}
	
	/**
	 * overrides toString in Object class. 
	 * Returns the name of the animal for printing
	 */
	@Override 
	public String toString() {
		return this.name;
	}
	
}
