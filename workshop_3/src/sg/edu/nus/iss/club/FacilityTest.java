package sg.edu.nus.iss.club;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FacilityTest extends TestCase{

	private Club club;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 club = new Club();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddFacility(){
		System.out.println(club.addFacility("Gym"));	
	}
}
