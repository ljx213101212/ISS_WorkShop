package sg.edu.nus.iss.club;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClubTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMember() {
		//Get member from the empty club
		Club club = new Club();
		assertNull(club.getMember(1));
		
		// pass an invalid parameter
		assertNull(club.getMember(0));
		assertNull(club.getMember(100));
		
		// add a member and ensure that you get the same member 
		Member member = new Member("Tan", "Siew", "Siew", 1);
		club.addMember("Tan", "Siew", "Siew");
		assertEquals (member, club.getMember(1));
		club.addMember("Tay", "May", "Ling");
		club.addMember("Wong", "Siew", "Fong");
		club.addMember("Pang", "Wai", "Hong");
		club.addMember("Chan", "Puay", "Siew");
		Member member3 = new Member("Wong", "Siew", "Fong", 3);
		assertEquals (member3, club.getMember(3));
	}

	@Test
	public void testGetMembers() {
		Club club = new Club();
		Member[] members = club.getMembers();
		assertTrue(members.length == 0);
		
		club.addMember("Tan1", "Siew", "Siew");
		club.addMember("Tan2", "Siew", "Siew");
		club.addMember("Tan3", "Siew", "Siew");
		club.addMember("Tan4", "Siew", "Siew");
		club.addMember("Tan5", "Siew", "Siew");
		club.addMember("Tan6", "Siew", "Siew");
		club.addMember("Tan7", "Siew", "Siew");
		club.addMember("Tan8", "Siew", "Siew");
		club.addMember("Tan9", "Siew", "Siew");
		club.addMember("Tan10", "Siew", "Siew");
		club.addMember("Tan11", "Siew", "Siew");
		club.addMember("Tan12", "Siew", "Siew");
		club.addMember("Tan13", "Siew", "Siew");
		
		members = club.getMembers();
		assertTrue(members.length == 13);
	}

	@Test
	public void testAddMember() {
		Club club = new Club();
		Member member = new Member("Tan1", "Siew", "Siew", 1);
		club.addMember("Tan1", "Siew", "Siew");
		assertEquals (member, club.getMember(1));
		
		// add more than 10 members
		club.addMember("Tan2", "Siew", "Siew");
		club.addMember("Tan3", "Siew", "Siew");
		club.addMember("Tan4", "Siew", "Siew");
		club.addMember("Tan5", "Siew", "Siew");
		club.addMember("Tan6", "Siew", "Siew");
		club.addMember("Tan7", "Siew", "Siew");
		club.addMember("Tan8", "Siew", "Siew");
		club.addMember("Tan9", "Siew", "Siew");
		club.addMember("Tan10", "Siew", "Siew");
		club.addMember("Tan11", "Siew", "Siew");
		club.addMember("Tan12", "Siew", "Siew");
		club.addMember("Tan13", "Siew", "Siew");
		
		Member member1 = new Member("Tan1", "Siew", "Siew", 1);
		Member member11 = new Member("Tan11", "Siew", "Siew", 11);
		assertEquals (member1, club.getMember(1));
		assertEquals (member11, club.getMember(11));
		
		
	}

	@Test
	public void testRemoveMember() {
		Club club = new Club();
		
		club.removeMember(1);
		
		Member member = new Member("Tan1", "Siew", "Siew", 1);
		club.addMember("Tan1", "Siew", "Siew");
		club.addMember("Tan2", "Siew", "Siew");
		club.addMember("Tan3", "Siew", "Siew");
		club.addMember("Tan4", "Siew", "Siew");
		club.addMember("Tan5", "Siew", "Siew");
		
		club.removeMember(1);
		assertFalse (member.equals(club.getMember(1)));
		Member member2 = new Member("Tan2", "Siew", "Siew", 2);
		assertTrue (member2.equals(club.getMember(2)));
		
		club.removeMember(5);
		Member member5 = new Member("Tan5", "Siew", "Siew", 5);
		assertFalse (member5.equals(club.getMember(5)));
		
		club.removeMember(3);
		Member member3 = new Member("Tan3", "Siew", "Siew", 3);
		assertFalse (member3.equals(club.getMember(3)));
		
	}

	@Test
	public void testShowMembers() {
		assertTrue(true);
	}

}
