package reservation;

import java.io.IOException;

import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		 Scanner sc = new Scanner(System.in);
		 System.out.println();
		 System.out.println();
		 System.out.println("		  ----- AIRLINE MANAGEMENT SYSTEM -----		  ");
		 System.out.println();
		 System.out.print("    Enter your designation (Admin / user): ");
	     String type;     
	     while(true){
	    	 type=sc.next();
	         if(type.equals("ADMIN")||type.equals("admin")||type.equals("Admin")||type.equals("USER")||type.equals("User")||type.equals("user"))
	         break;
	         System.out.println();
	         System.out.println("\t\t\t!!Oops.. Wrong Designation!!");
	         System.out.println();
	         System.out.print("    Enter correct designation: ");
	     }
	     System.out.println();
	     System.out.println();
	     if(type.equals("ADMIN")||type.equals("admin")||type.equals("Admin")){
	    	 System.out.println("		       ----------------------------------		  ");
	    	 System.out.println("		      |            ADMIN PART            |		  ");
	    	 System.out.println("		       ----------------------------------		  "); 
	    	 System.out.println();
	    	 System.out.println();
	    	 System.out.print("    ENTER YOUR PASSWORD: ");
	         String password;
	         password=sc.next();
	         System.out.println();
	         if(password.equals("java")){ 
	        	 int select1;  
	             do{            	 
	            	 System.out.print("\n\tMENU");
	            	 System.out.print("\n\t1.Create flight record");
	            	 System.out.print("\n\t2.Display all flight records");
	            	 System.out.print("\n\t3.Logout");
	            	 System.out.println();
	            	 System.out.println();
	            	 System.out.print("	Select your option (1/2/3): ");
	            	 select1=sc.nextInt();
	            	 while(select1>3 || select1<1){
	                    	System.out.println("\n\t\tInvalid Choice..");
	                    	System.out.println();
	                    	System.out.print("\tPlease select your choice correctly(1/2/3): ");
	                    	select1=sc.nextInt();
	                 }
	            	 System.out.println();
	            	 Admin admin = new Admin();
	            	 switch(select1){
	                  	case 1: 
	                  			admin.create_flight_record();
	                  			break;
	                  	case 2:
	                  		    admin.display_flight_record();
	                            break;
	                  	case 3:
	                  			System.out.println("\n\t\t\tlogging out...");
	                  			for (long i = 0; i < 1000000000; i++){
	                  				for(long j = 0; j < 10; j++) {
	                  					
	                  				}
	                  			}         	
	                  			System.out.println("\n\t\t\t!!See you again..logged out!!");
	                  			System.out.println();
	                  			break;
	                 }
	             }while(select1!=3);
	        }
	        else{
	        	System.out.println("\n\t\t\t!!Oops.. Wrong Password!!");
	        	System.out.println();
	        }
	     }
	     else{
	    	 System.out.println("		       -----------------------------------------------		  ");
	    	 System.out.println("		      |            WELCOME TO QATAR AIRWAYS            |		  ");
	    	 System.out.println("		       -----------------------------------------------		  "); 
	    	 System.out.println();
	    	 int select2;  
             do{            	 
            	 System.out.print("\n\tMENU");
            	 System.out.print("\n\t1.Book a flight");
            	 System.out.print("\n\t2.My Bookings");
            	 System.out.print("\n\t3.Search for flights");
                 System.out.print("\n\t4.Display all flights");
            	 System.out.print("\n\t5.Get symbols for airports"); 
            	 System.out.print("\n\t6.Cancellation");
            	 System.out.print("\n\t7.Logout");
            	 System.out.println();
            	 System.out.println();
            	 System.out.print("	Select your option (1/2/3/4/5/6/7): ");
            	 select2=sc.nextInt();
            	 while(select2> 7|| select2<1){
                    	System.out.println("\n\t\tInvalid Choice..");
                    	System.out.println();
                    	System.out.print("\tPlease select your choice correctly(1/2/3/4/5/6/7): ");
                    	select2=sc.nextInt();
                 }
            	 System.out.println();
            	 User user = new User();
            	 Admin admin2 = new Admin();
            	 switch(select2){
               		case 1: 
               				user.book_a_flight();
               				break;
               		case 2:
               				user.my_bookings();
               		    	break;
               		case 3:
               				user.search_for_flights();
               				break;
               		case 4:
               			    admin2.display_flight_record();
               			    break;
               		case 5:
               				user.get_symbols();
               				break;
               		case 6:
               				user.cancellation();
               				break;
               		case 7:
               				System.out.println("\n\t\t\tlogging out...");
               				for (long i = 0; i < 1000000000; i++){
               					for(long j = 0; j < 10; j++) {
               					
               					}
               				}         	
               				System.out.println("\n\t\t\t!!See you again..logged out!!");
               				System.out.println();
               				break;
              }
             }while(select2!=7);
	     }
	}

}
