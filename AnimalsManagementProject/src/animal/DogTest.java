package animal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DogTest {

	@Test
	void testEqualsObject() {
		// this assumes we've implemented the equals method in the dog class 
		
		Dog dog1 = new Dog(4, "Pug");
		dog1.setName("Tommy");
		

		Dog dog2 = new Dog(8, "Pug");
		dog2.setName("Tommy");
		
		// dogs should be equal 
		assertEquals(dog1, dog2);
		
		
	}
	

}
