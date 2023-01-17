package animal;

/**
 * Represents a cat and extends the animal class 
 * @author Thoma
 *
 */
public class Cat extends Animal {

	// Static variables for default values 
	
	/**
	 * Default type for cat 
	 */
	static String DEFAULT_TYPE ="domestic";
	
	// instance variables
	
	/**
	 * Type of cat
	 */
	private String type;
	
	// Also inherits variables defined in the animal super class 
	
	// constructor 
	
	/**
	 * Creates a cat with a given age
	 * @param age of cat 
	 */
	public Cat(int age) {
		// calls constructor in super class animal 
		super(age);
		
		// Set type of cat to default value 
		this.type = Cat.DEFAULT_TYPE;
	}
	
	
	// getters and setters 
	
	/**
	 * Gets the type of cat 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of cat
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	// Other methods 
	
	/**
	 * Overrides speaks method in superclass Animal 
	 */
	@Override
	public void speak() {
		System.out.println(this.name + " says: Meow!");
	}
	
	/**
	 * Returns the name and type of this cat for printing 
	 */
	@Override
	public String toString() {
		return this.name + " is a " + this.type;
	}
	
	
	
	
	
	
}
