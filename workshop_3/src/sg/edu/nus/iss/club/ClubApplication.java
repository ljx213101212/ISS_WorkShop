package sg.edu.nus.iss.club;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClubApplication {

	/*
	public static void checktime(String start, String end) throws BadBookingException{
		
		//throw new BadBookingException(bk.,bk.f,start,end);
		Date temp_s_date = new Date(start);
		Date temp_e_date = new Date (end);
		
		if (temp_s_date.after(temp_e_date)){
		throw new BadBookingException("the time is wrong!");
		//return false;
		}
	}
	*/
    public static void main (String args[]) throws BadBookingException{

        Club club = new Club ();
       /*
        Member removableMember;

        club.addMember ("Einstein", "Albert", null);
        club.addMember ("Picasso", "Pablo", "Ruiz");
        removableMember = club.addMember ("Webber","Andrew","Lloyd");
        club.addMember ("Baggio", "Roberto", null);
        club.addMember ("Raffles", "Stamford", null);

        System.out.println ("Current Members:");
        club.showMembers ();

        System.out.println ("Deleting " + removableMember);
        int id = removableMember.getMemberNumber ();
        club.removeMember (id);

        System.out.println ("Current members:");
        club.showMembers ();
        */
        
        System.out.println(club.addFacility("Gym"));
        System.out.println(club.addFacility("Toliet"));
        System.out.println(club.addFacility("Cantin"));
        
        
        
        //System.out.println(club.getFacility("Gm"));
        //System.out.println(club.getFacilities().get("Toliet"));
        
        //club.removeFacilitiy("Toliet");
        //club.removeFacilitiy("Can");
        //System.out.println(club.getFacilities().get("Toliet"));
        
        //club.showFacility();
        
        
        club.addMember("Li","Genius","Jixiang");
       
        //club.removeMember(0);
        //Facility f1 =new Facility("Discuss room","practicing and enhancing!");
        Date s_d1 = new Date("2007/3/1 15:00");
        Date e_d1 = new Date("2007/3/1 15:00");
        
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:mm");
        
        //System.out.println(club.getMember(1));
 
        	try {
        		BadBookingException bad = new BadBookingException("",club.getMember(1),club.getFacility("Toliet"),sdf.format(s_d1),sdf.format(e_d1));
        		if (bad.time_appriopriate == false){
        			throw new BadBookingException("The date is not correct");
        		}
        		Booking bk_1 = new Booking(club.getMember(1),club.getFacility("Toliet"),sdf.format(s_d1),sdf.format(e_d1)); 
        	        //BadBookingException bad = new BadBookingException(m1,club.getFacility("Toliet"),sdf.format(s_d1),sdf.format(e_d1));
        	    bk_1.toString();
        	    BookingRegister br_1 = new BookingRegister(club);
				br_1.addBooking(bk_1);
        	    
			} catch (BadBookingException e) {
				// TODO Auto-generated catch block
			}
        
     }
      
        
   }


