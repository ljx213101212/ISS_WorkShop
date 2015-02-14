package sg.edu.nus.iss.club;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookingRegisterTest extends TestCase{

	Club club = new Club();
	SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:mm");
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		club.addFacility("Gym");
		club.addFacility("Toliet");
		club.addFacility("Cantin");
		club.addMember("Li","Genius","Jixiang");
		club.addMember("Martin","Luther","King");
		club.addMember("O","Ba","Ma");
		
		Date s_d1 = new Date("2007/3/1 14:30");
	    Date e_d1 = new Date("2007/3/1 14:31");
	    
	    Date s_d2 = new Date("2007/3/1 14:28");
	    Date e_d2 = new Date("2007/3/1 14:31");
	    
	    
	    
    		//BadBookingException bad = new BadBookingException("",club.getMember(1),club.getFacility("Toliet"),sdf.format(s_d1),sdf.format(e_d1));
	    Booking bk_1 = new Booking(club.getMember(1),club.getFacility("Toliet"),sdf.format(s_d1),sdf.format(e_d1)); 
        //BadBookingException bad = new BadBookingException(m1,club.getFacility("Toliet"),sdf.format(s_d1),sdf.format(e_d1));
        bk_1.toString();
        
        //Booking bk_2 = new Booking(club.getMember(2),club.getFacility("Cantin"),sdf.format(s_d2),sdf.format(e_d2));
        Booking bk_2 = new Booking(club.getMember(2),club.getFacility("Toliet"),sdf.format(s_d2),sdf.format(e_d2));
        BookingRegister br_1 = new BookingRegister(club);
	    br_1.addBooking(bk_1);
	    br_1.addBooking(bk_2);
	    
	    br_1.getBookings(club.getFacility("Toliet"), "2007/3/1 14:22", "2007/3/1 14:31");
	    //br_1.removeAllBookings(bk_1.fac);
	    br_1.removeBooking(bk_1.mem, bk_1.fac, "2007/3/1 14:22", "2007/3/1 14:21");
	    br_1.showAllBookings(club.getFacility("Toliet"));
	    
	    
	    
	}

}
