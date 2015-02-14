package sg.edu.nus.iss.club;

import java.util.Date;

public class Booking {

	public Member mem;
	public Facility fac;
	
	private String Member_first_name;
	private String Member_surname;
	private String Member_second_name;
	
	private  String Facility_name;
	private String Facility_description;
	
	public Date start_date,end_date;
	
	public Booking (Member m , Facility f , String start, String end){
		mem = m;
		fac = f;
		
		Member_first_name =  m.getFirstName();
		Member_surname = m.getSurname();
		Member_second_name = m.getSecondName();
		
		
		Facility_name = f.getName();
		Facility_description = f.getDescription();
		
		start_date = new Date(start);
		end_date = new Date(end);
		
		if (IsTimeValid(start_date,end_date)){
			
		}else{
			System.out.println("end_date can not be before start_date");
			System.exit(1);
		}
	}
	
	public boolean IsTimeValid( Date start, Date end){
		
		if (end.before(start))
			return false;
		else
			return true;
		
	}
	
	
	public String toString(){
		
		String member_info,facility_info,start_date,end_date;
        
		member_info = Member_first_name+" "+Member_surname+" "+Member_second_name;
		facility_info = Facility_name;
		start_date = "Start AT: "+ this.start_date;
		end_date = "End AT: "+ this.end_date;

		
		System.out.println(member_info);
		System.out.println(facility_info);
		System.out.println(start_date);
		System.out.println(end_date);
		
		return "1";
		
	}
	
}
