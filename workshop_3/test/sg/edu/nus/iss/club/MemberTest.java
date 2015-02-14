package sg.edu.nus.iss.club;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberTest {

	@Test
	public void testEquals() {
		Member m1 = new Member("Swarna", "Latha", "Ashok", 1);
		Member m2 = new Member("Swarna", "Latha", "Ashok", 1);
		Member m3 = new Member("Pushpa", "Valli", "Ganesh", 3);
		
		assertFalse (m1.equals(m3));
		assertEquals(m1,m2);
	}

}
