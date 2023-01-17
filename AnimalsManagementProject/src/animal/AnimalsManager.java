package animal;

import java.util.ArrayList;

/**
 * A class for managing animals 
 * @author Thoma
 *
 */

public class AnimalsManager {
	
	
	//instance variables 
	
	/**
	 * List of all animals 
	 */
	ArrayList<Animal> animals;
	
	
	//constructor
	
	/**
	 * Creates animals manager and initializes a list of all animals 
	 */
	public AnimalsManager() {
		//initializes animal array list 
		this.animals = new ArrayList<Animal>();
	}
			

	//methods
	
	
	/**
	 * Prints the list of animals 
	 */
	public void printAnimals() {
		
		for (Animal a: this.animals) {
			//calls the toString method in the respective animals class 
			//iterates over the list of animals and prints each on 
			System.out.println(a);
		}
	}
	
	/**
	 * Tells all animals to speak
	 */
	public void animalsSpeak() {
		for (Animal a: this.animals) {
			//this will call the speak method in the respective animal class 
			//speak in animal class or overridden speak in subclass of animal 
			a.speak();
		}
	}
	
	
	public static void main(String[] args) {
	
		//create a generic animal 
		Animal animal = new Animal(2);
		
		//calls setName defined in Animal class
		animal.setName("bob the animal");
	
		//print the animal 
		//this calls toString defined in Animal class 
		System.out.println(animal);
		
		
		//create a dog 
		Dog dog1 = new Dog(4, "Pug");
		
		//calls setName defined in the animal class 
		dog1.setName("Puggles");
		
		//create another dog 
		Dog dog2 = new Dog(9, "Pug");
		
		//calls setName defined in the animal class (bc it has not been overriden in the dog class)
		dog2.setName("Puggles");
		
		
		//create a cat 
		Cat cat1 = new Cat(8);
		cat1.setName("Teddy"); //calls setName defined in Animal class 
		cat1.setType("outside"); //calls setType defined in Cat class 
		
		System.out.println(cat1); //inherently calling the twoString() defined in cat class 
		
		//create instance of AnimalsManager
		AnimalsManager animalsManager = new AnimalsManager();
		
		// add each animal to arraylist animals 
		animalsManager.animals.add(animal);
		animalsManager.animals.add(dog1);
		animalsManager.animals.add(dog2);
		animalsManager.animals.add(cat1);
		
		//print all animals in the animals ArrayList
		System.out.println("");
		animalsManager.printAnimals(); //calls toString() in each class
		
		animalsManager.animalsSpeak();
		
		System.out.println("");
		
		//compare dog1 to dog2 
		//are they equal? 
		System.out.println("");
		
		//calls equals method defined in dogs class 
		System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
		
		//calls the setBreed method in the dog class
		dog2.setBreed("Golden Retriever");
		
		//compare again
		System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
	}
	

}
