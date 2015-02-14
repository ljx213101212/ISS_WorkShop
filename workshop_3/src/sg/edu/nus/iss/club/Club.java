package sg.edu.nus.iss.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Club {

    private static final int ARRAY_SIZE_INCREMENT = 10;

    private int    numMembers = 0;
    private int    numFacilities = 0;  
    private int    count = 0;
    //private Member members[] = new Member [ARRAY_SIZE_INCREMENT];
    ArrayList<Member> members = new ArrayList();
    HashMap<String,Facility> facilities = new HashMap<String, Facility>();

    public Member getMember (int memberNum) {
        if ((memberNum < 1) || (memberNum > numMembers)) {
            return null;
        }
        return members.get(memberNum - 1);
    }
    
    
     public Facility getFacility(String name) {
	
              if (facilities.get(name) != null) {
            	  return facilities.get(name);
              }else{
            	  System.out.println("Can not find the facility");
            	  return null;
              }
            	
    }
    
    
    public ArrayList<Member> getMembers () {
        //Member[] arr = new Member[count];
    	ArrayList <Member> arr = new ArrayList();
        //int j = 0;
        for (int i = 0; i < numMembers; i++) {
            if (members.get(i) != null) {
                //arr[j++] = members.get(i);
            	arr.add(members.get(i));
            }
        }
        return arr;
    }

     public HashMap <String,Facility> getFacilities() {
		
    	HashMap<String,Facility> fac = new HashMap();
       //fac.forEach(arg0);

    	Iterator iter = facilities.entrySet().iterator();
    	
    	while (iter.hasNext()) {
    		  Map.Entry<String, Facility> entry = (Entry<String, Facility>) iter.next();
    		  fac.put(entry.getKey(),entry.getValue());
    		  // ...
        }
    	return fac; 	
    }
    
   
    public Member addMember (String surname, String firstName,
                                             String secondName) {
        //ensureArraySize ();
        numMembers++;
        Member m = new Member (surname, firstName, secondName,
                                                   numMembers);
        //members[numMembers - 1] = m;
        //members.set(numMembers, m);
        members.add(m);
        count++;
        return m;
    }

    
    public Facility addFacility(String name){
		
    	numFacilities++;
    	Facility faci = new Facility(name);
    	facilities.put(name, faci);
    
    	return faci;
    }
    public void removeMember (int memberNum) {
        if ((memberNum < 1) || (memberNum > numMembers)) {
            return;
        }
        if (members.get(memberNum - 1)!= null) {
           // members[memberNum-1] = null;
        	members.set(memberNum-1,null);
            count--;
        }
    }
    
    public void removeFacilitiy (String name){
    	
    	if (facilities.get(name) != null) {
      	   facilities.remove(name);
        }else{
      	  System.out.println("This facility is not exist, so it could not be removed");
      	  return;
        }
      	
    }

    public void showMembers () {
    	ArrayList <Member> arr = getMembers();
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).show ();
        }
    }
    
    public void showFacility(){
    	HashMap <String,Facility> hm = getFacilities();
        
    	
	  Iterator iter = hm.entrySet().iterator();
    	
    	while (iter.hasNext()) {
    		  Map.Entry<String, Facility> entry = (Entry<String, Facility>) iter.next();
    		  //fac.put(entry.getKey(),entry.getValue());
    		  entry.getValue().show();
    		  // ...
        }
    }

    
    public void show(){
    	
    	showFacility();
    	showMembers();
    }
    /*
    private void ensureArraySize () {
        if (numMembers >= members.length) {
            Member newMembers[];
            int newSize = numMembers + ARRAY_SIZE_INCREMENT;
            newMembers = new Member[newSize];
            for (int i = 0; i < numMembers; i++) {
                newMembers[i] = members[i];
            }
            members = newMembers;
        }
    }*/
    
  
}
