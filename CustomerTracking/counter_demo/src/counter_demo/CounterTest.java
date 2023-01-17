package counter_demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CounterTest {

	// Declare a counter object for testing 
	Counter counter;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		// initialize a new counter before every test method 
		this.counter = new Counter(); 
	}

	@Test
	void testIncrement() {
		// Calling increment the first time should return 1
		assertTrue(this.counter.increment() == 1);
		
		// 2nd call should return 2
		assertTrue(this.counter.increment() == 2);
		
		this.counter.increment();
		
		assertFalse(this.counter.getCount() == 2, "Should not return 2 after 3 calls");
		
		
		// Since we are expecting 3 
		assertEquals(3, this.counter.getCount());
		
		assertNotEquals(3, this.counter.increment());
		
	}

	@Test
	void testDecrement() {
		
		// Calling decrement the first time should return -1 
		assertEquals(-1, this.counter.decrement());
		
		// Calling decrement again returns -2 
		assertTrue(this.counter.decrement() == -2);
		
		// Call decrement a third time
		this.counter.decrement();
		
		// Should not return -2
		assertFalse(this.counter.getCount() == -2, "Should not return -2 post 3 calls");
		
		// calling getCount() should return -3 
		assertTrue(this.counter.getCount() == -3);
	
	}

}
