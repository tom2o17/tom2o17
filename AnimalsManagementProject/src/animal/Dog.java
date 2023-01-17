package animal;

/**
 * Represents a dog and extends the animal class 
 * @author Thoma
 *
 */
public class Dog extends Animal {

	// instance variables 
	
	/**
	 * Breed of dog
	 */
	private String breed;
	
	//constructor 
	
	/**
	 * Creates a dog with given age and breed.
	 * @param age of dog
	 * @param breed of dog 
	 */
	public Dog(int age, String breed) {
		// calls constructor in superclass animal
		super(age);
		
		// sets breed of dog 
		this.breed = breed;
	}
	
	
	//getters/setters
	

	/**
	 * gets the breed of dog 
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * sets the breed of dog 
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	//other methods 
	
	/**
	 * Overrides the speak method in superclass animal 
	 * Dog speaks
	 */
	@Override
	public void speak() {
		System.out.println(this.name +" says: fear my bark ");
	}
	
	/**
	 * Returns the name and breed of dog for printing 
	 */
	@Override
	public String toString() {
		return this.name + " is a " + this.breed;
	}
	
	
	/**
	 * Overrides the equals method in the Object superclass 
	 * Compares two dog for equality based on their name and breed 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		
		//casts given obj to a dog 
		Dog otherDog = (Dog) obj;
		
		//compare two dogs based on their name and breed
		return (this.name.equals(otherDog.name) && this.breed.equals(otherDog.breed));
	}
	
}
