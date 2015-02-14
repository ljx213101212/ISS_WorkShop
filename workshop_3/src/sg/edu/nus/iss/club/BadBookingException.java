package sg.edu.nus.iss.club;

import java.util.Date;

public class BadBookingException extends Exception{

	private String without_mem = "The information of member can not be blank";
	private String without_fac = "The information of facility can not be blank";
	private String without_start = "The start date is not allowed to be omitted";
	private String without_end = "The end date is not allowed to be omitted";
	private String sys_wrong = "the start date can not be after the end date";
	
	public boolean time_appriopriate = true;

	public BadBookingException(String message){
		super(message);
	}
	
	public BadBookingException(String message, Member m , Facility f , String start, String end) throws BadBookingException{
		super(message);
		
		//System.out.println("Error! And the reason is: ");
		if (m == null){
			System.out.println(without_mem);
		}
		if (f == null){
			System.out.println(without_fac);
		}
		if (start == null){
			System.out.println(without_start);
		}
		if (end == null){
			System.out.println(without_end);
		}
		if (compare_whether_wrong(start,end)){
			//System.out.println("time is right");
		}else {
			
			System.out.println(sys_wrong);
			this.time_appriopriate = false;
		}
	}
	
	public BadBookingException(String message,String ori_start,String ori_end, String add_start, String add_end){
	
		
		
	}
	public boolean compare_whether_wrong(String start, String end){
		Date temp_s_date = new Date(start);
		Date temp_e_date = new Date (end);
		
		if (temp_s_date.after(temp_e_date)){
		return false;
		}else{
	    return true;
		}
	}
}
