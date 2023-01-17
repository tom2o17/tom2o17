package roles;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class AdminTest {


	@Test
	void testAdmin() {
		Admin admin = new Admin("001", "John Doe", "admin007", "password101");
		assertEquals(admin.adminId, "001");
		assertEquals(admin.name, "John Doe");
		assertEquals(admin.userName, "admin007");
		assertEquals(admin.getPassword(), "password101");
	
	}

}
