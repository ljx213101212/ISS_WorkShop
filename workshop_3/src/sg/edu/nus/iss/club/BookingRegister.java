package sg.edu.nus.iss.club;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BookingRegister {

	private HashMap<Facility,ArrayList<Booking>> register_list = new HashMap<Facility,ArrayList<Booking>>();
	
	
	public BookingRegister(Club club){
	    
       //int test_counter = 0;		
       Iterator iter = club.getFacilities().entrySet().iterator();
    	while (iter.hasNext()) {
    		  //ArrayList<Booking> booking_arr = new ArrayList<Booking>();
    		  //Booking temp = new Booking(club.getMember(1),club.getFacility("Gym"),"1","2");
    		  //booking_arr.add(temp);
    		  Map.Entry<String, Facility> entry = (Entry<String, Facility>) iter.next();
    		  register_list.put(entry.getValue(),null);
    		  // ...
    		  
    		  //test_counter ++;
        }
    	//System.out.println(test_counter);
  }
	
	
	public boolean isOverlapped(Booking bk, String start, String end){
		
		  if ((bk.start_date.before(StringtoDate(start)) && 
  	            bk.end_date.after(StringtoDate(start)))
  	       || (bk.start_date.before(StringtoDate(end)) &&
  	            bk.end_date.after(StringtoDate(end)))|| (bk.start_date.after(StringtoDate(start)) &&
  	           bk.end_date.before(StringtoDate(end)))
  	               ){
		
			  return true;
		  }
		
		return false;
		
	}
		  
		  
    public Date StringtoDate(String s){
    	
    	Date date = new Date(s);
        return date;
    	
    }
    
    public String DateFormat(String s){
    	
    	Date date = new Date(s);
        SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:mm");
        
        String result = sdf.format(s); 
        
        return result;
    }
	
	public ArrayList<Booking> getBookings(Facility f, String start, String end) {
		
		ArrayList<Booking> booking_arr = new ArrayList<Booking>();
		Iterator iter = register_list.entrySet().iterator();
		
		boolean findornot = false;
		while(iter.hasNext()) {
			Map.Entry<Facility,ArrayList<Booking>> entry = (Entry<Facility,ArrayList<Booking>>) iter.next();
			if (entry.getKey().equals(f)){
				findornot = true;
			    for (int i = 0; i < entry.getValue().size(); i++) {
			    	if(isOverlapped(entry.getValue().get(i),start,end)){
			    		booking_arr.add(entry.getValue().get(i));
			    	}
			    }
				
			}
		}
		
		show(booking_arr,"getBookings");
		return booking_arr;
		
	}
	
	
	public HashMap<Facility,ArrayList<Booking>> addBooking(Booking bk){
		
		 Iterator iter = register_list.entrySet().iterator();
		 
		 boolean addornot = true;
	    	while (iter.hasNext()) {
	    		
	    		Map.Entry<Facility,ArrayList<Booking>> entry = (Entry<Facility,ArrayList<Booking>>) iter.next();
	    		if (entry.getValue() == null){
	    			ArrayList<Booking> booking_arr = new ArrayList<Booking>();
	    			register_list.put(entry.getKey(), booking_arr);
	    		}
	    		
	    		if (entry.getKey().getName() == bk.fac.getName()){
	    			//retrieve ArrayList
	    			//ArrayList <Booking> arr = new ArrayList();
	    	        //int j = 0;
	    			if (entry.getValue().size() == 0){
	    				entry.getValue().add(bk);
    	            	System.out.println("add successfully1");
	    			}else{
	    	        for (int i = 0; i < entry.getValue().size(); i++) {
	    	            if ((entry.getValue().get(i).start_date.before(bk.start_date) && 
	    	            entry.getValue().get(i).end_date.after(bk.start_date))
	    	       || (entry.getValue().get(i).start_date.before(bk.end_date) &&
	    	            entry.getValue().get(i).end_date.after(bk.end_date))
	    	       || (entry.getValue().get(i).start_date.after(bk.start_date) &&
	    	            entry.getValue().get(i).end_date.before(bk.end_date))
	    	               ){
	    	                
	    	            	System.out.println("Overlaped! , Failed to book");
	    	            	addornot=false;
	    	            	break;
	    	            }/*else{
	    	            	entry.getValue().add(bk);
	    	            	System.out.println("add successfully2");
	    	            	break;
	    	            }*/
	    	         }
	    	             if (addornot){
	    	                entry.getValue().add(bk);
	            	        System.out.println("add successfully2");
	    	             }else{
	    	            	 System.out.println("nothing add");
	    	             }
	    	             
	    	             }//end else
	    			
	    		}
	    	}
		
		
		return null;
	}
	
   public void removeBooking(Member m , Facility f, String start , String end){
	   
	   Iterator iter = register_list.entrySet().iterator();
		
		//boolean findornot = false;
		while(iter.hasNext()) {
			Map.Entry<Facility,ArrayList<Booking>> entry = (Entry<Facility,ArrayList<Booking>>) iter.next();
			if (entry.getKey().equals(f)){
				 
				 for (int i = 0; i < entry.getValue().size(); i++) {
					 
					 if (entry.getValue().get(i).mem.equals(m)){
						 if(isOverlapped(entry.getValue().get(i),start,end)){
							 entry.getValue().remove(i);
							 //System.out.println(entry.getValue().get(i));
						 }
						 
					 }
				 }
			}
			
		}
	   
	   
   }
	
	
	public void removeAllBookings(Facility f){
		
        Iterator iter = register_list.entrySet().iterator();
		
		//boolean findornot = false;
		while(iter.hasNext()) {
			Map.Entry<Facility,ArrayList<Booking>> entry = (Entry<Facility,ArrayList<Booking>>) iter.next();
			if (entry.getKey().equals(f)){
				entry.getValue().clear();;
			}
			
		}
		
	}
	
	
	public void showAllBookings(Facility f){
		 Iterator iter = register_list.entrySet().iterator();
			
			//boolean findornot = false;
			while(iter.hasNext()) {
				Map.Entry<Facility,ArrayList<Booking>> entry = (Entry<Facility,ArrayList<Booking>>) iter.next();
				if (entry.getKey().equals(f)){
					show(entry.getValue(),"showAllBookings");
				}
				
			}
		
	}
	public void show(ArrayList<Booking> arr , String distinguish){
		
		System.out.println("");
		System.out.println("This is the result of " + distinguish);
		System.out.println("---------------------------");
		
		
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        
        System.out.println("---------------------------");
	}
	
	
}
