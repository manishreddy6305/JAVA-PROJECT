package reservation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import Payment.Card;
import Payment.NetBanking;
import Payment.Upi;

public class User {
	public void book_a_flight() {
		Scanner sc = new Scanner(System.in);
		boolean flights_available=search_for_flights();
		String confirmation,flight_class,flight_code,de_date,de_time,no_of_seats;
		String price = "0";
		System.out.println();
		if(flights_available) {
			System.out.print("\tAre you sure do you want to confirm the booking ? (Yes / No) : ");
			confirmation=sc.next();
			System.out.println();
			if(confirmation.equals("Yes")){
				System.out.print("\tPlease enter your prefered class (Economy / Business) : ");
				flight_class=sc.next();
				System.out.println();
				System.out.print("\tEnter flight code : ");
				flight_code=sc.next();
				System.out.println();
				System.out.print("\tEnter flight depature date : ");
				de_date=sc.next();
				System.out.println();
				System.out.print("\tEnter  depature time : "); 
				de_time=sc.next();
				System.out.println();
				System.out.print("\tNumber of seats do you want to book : "); 
				no_of_seats=sc.next();
				System.out.println();
				File myFile_v = new File("flightdata.txt");
				int counter_sub=0;
				try {
					Scanner sc1 = new Scanner(myFile_v);
					while(sc1.hasNextLine()){
			            Vector<String> vector= new Vector<String>();
			            String line = sc1.nextLine();
			            String dummy = "";
			            for(int i=0;i<line.length();i++) {
			                if(line.charAt(i)==' ') {
			                	vector.add(dummy);
			                	dummy="";
			                }
			                else {
			                	dummy+=line.charAt(i);
			                }
			            }
			            if(vector.get(6).equals(flight_code)&&vector.get(2).equals(de_time)&&vector.get(4).equals(de_date)) {
		            		if(flight_class.equals("Economy")) {
		            			price=vector.get(7);
		            		}
		            		else {
		            			price=vector.get(8);
		            		}
		            		counter_sub++;
		            	}
			        }
					if(counter_sub==0) {
						System.out.println("Enter correct flight details ");
					}
				}
				catch (IOException e) {
		            e.printStackTrace();
		        }
				if(counter_sub!=0) {
				System.out.println("\tWait for few seconds redirecting to payment gateway ...");
				for (long i = 0; i < 1000000000; i++){
      				for(long j = 0; j < 10; j++) {
      					
      				}
      			}
				System.out.println();
				System.out.println("		       --------------------------------------		  ");
		    	System.out.println("		      |            PAYMENT GATEWY            |		  ");
		    	System.out.println("		       --------------------------------------		  "); 
		    	System.out.println();
		    	int select2;  
		    	String exit = "";
		    	int done=0;
	            do{            	 
	            	 System.out.print("\n\tMENU");
	            	 System.out.print("\n\t1.NET BANKING");
	            	 System.out.print("\n\t2.UPI");
	            	 System.out.print("\n\t3.CREDIT / DEBIT CARD");
	            	 System.out.print("\n\t4.EXIT");
	            	 System.out.println();
	            	 System.out.println();
	            	 System.out.print("	Select your option (1/2/3/4): ");
	            	 select2=sc.nextInt();
	            	 while(select2> 4|| select2<1){
	                    	System.out.println("\n\t\tInvalid Choice..");
	                    	System.out.println();
	                    	System.out.print("\tPlease select your choice correctly(1/2/3/4): ");
	                    	select2=sc.nextInt();
	                 }
	            	 System.out.println();
	            	 Admin cb =new Admin();
	            	 switch(select2){
	               		case 1: 
	               				String name,phone_num,email;
	               				System.out.print("\tEnter your name : ");
	               				name=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your phone number : ");
	               				phone_num=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your email id : ");
	               				email=sc.next();
	               				System.out.println();
	               				NetBanking pay = new NetBanking(name,phone_num,email,price);
	               				pay.payment();
	               				cb.customer_booking(flight_class,flight_code, de_time, de_date,no_of_seats);
	               				done++;
	               				break;
	               		case 2:
	               				String name2,phone_num2,email2,Upi_id,Upi_pin;
	               				System.out.print("\tEnter your name : ");
	               				name2=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your phone number : ");
	               				phone_num2=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your email id : ");
	               				email2=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your Upi id : ");
	               				Upi_id=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your Upi pin : ");
	               				Upi_pin=sc.next();
	               				Upi pay2= new Upi(name2,phone_num2,email2,price,Upi_id,Upi_pin);
	               				pay2.payment();
	               				cb.customer_booking(flight_class,flight_code, de_time, de_date,no_of_seats);
	               				done++;
	               		    	break;
	               		case 3:
	               				String name3,phone_num3,email3,card_type,card_num,card_cvv,card_expiry,card_name;
	               				System.out.print("\tEnter your name : ");
	               				name3=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your phone number : ");
	               				phone_num3=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your email id : ");
	               				email3=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter Credit / Debit card : ");
	               				card_type=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your card number : ");
	               				card_num=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter name on your card : ");
	               				card_name=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your card expiry date : ");
	               				card_expiry=sc.next();
	               				System.out.println();
	               				System.out.print("\tEnter your card CVV : ");
	               				card_cvv=sc.next();
	               				Card pay3= new Card(name3,phone_num3,email3,price,card_name,card_num,card_type,card_expiry,card_cvv);
	               				pay3.payment();
	               				cb.customer_booking(flight_class,flight_code, de_time, de_date,no_of_seats);
	               				done++;
	               				break;
	               		case 4: 
	               				System.out.print("\tAre you sure (Yes / No) : ");
	               				exit=sc.next();
	               				done++;
	               			    break;
	              }
	             }while(!exit.equals("Yes")&&done==0);
			 }
			}
			else {
				System.out.println("Booking cancelled !!");
			}
		}
		else
			System.out.println("\tSorry booking cancelled !!");
	}
	public void my_bookings() {
		File myFile = new File("Userdata.txt");
        try {
            Scanner sc = new Scanner(myFile);
            System.out.println();
	    	System.out.println("\t\t\t\t       ------ MY BOOKINGS ------");
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("\tCODE  | DEP-ARR |     TIME     |          DATE          |   CLASS   | PRICE PER SEAT | NUMBER OF SEATS");
	    	System.out.println("\t-------------------------------------------------------------------------------------------");
	    	System.out.println();
	    	if(myFile.length()==0) {
	    		System.out.println("\tNo Bookings.");
	    	}
	    	else {
	    	while(sc.hasNextLine()){
            	Vector<String> vector= new Vector<String>();
                String line = sc.nextLine();
                String dummy = "";
                for(int i=0;i<line.length();i++) {
                	if(line.charAt(i)==' ') {
                		vector.add(dummy);
                		dummy="";
                	}
                	else {
                		dummy+=line.charAt(i);
                	}
                }
                System.out.println("\t"+vector.get(6)+"   "+vector.get(0)+"-"+vector.get(1)+"    "+vector.get(2)+" "+vector.get(3)+"   "+vector.get(4)+"  "+vector.get(5)+"    "+vector.get(7)+"          "+vector.get(8)+"          "+vector.get(9));
                System.out.println();
            }
	    	}
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	public boolean search_for_flights() {
		Scanner sc = new Scanner(System.in);
		String de_airport, arr_airport, de_date;
		System.out.println();
    	System.out.println("\t\t\t\t       ------ ENTER YOUR FLIGHT DETAILS ------");
    	System.out.println();
		System.out.print("\tEnter depature airport : "); 
		de_airport=sc.next();
		System.out.println();
		System.out.print("\tEnter arrival airport : "); 
		arr_airport=sc.next();
		System.out.println();
		System.out.print("\tEnter depature date : "); 
		de_date=sc.next();
		System.out.println();
		System.out.println();
		int scheduled_flight=0;
		File myFile = new File("flightdata.txt");
        try {
            Scanner sc1 = new Scanner(myFile);
            System.out.println();
	    	System.out.println("\t\t\t\t       ------ FLIGHT RECORDS ------");
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("\tCODE  | DEP-ARR |     TIME     |          DATE          | EPRICE | BPRICE | ESEATS | BSEATS");
	    	System.out.println("\t------------------------------------------------------------------------------------------");
	    	System.out.println();
	    	while(sc1.hasNextLine()){
            	Vector<String> vector= new Vector<String>();
                String line = sc1.nextLine();
                String dummy = "";
                for(int i=0;i<line.length();i++) {
                	if(line.charAt(i)==' ') {
                		vector.add(dummy);
                		dummy="";
                	}
                	else {
                		dummy+=line.charAt(i);
                	}
                }
                if(vector.get(0).equals(de_airport)&&vector.get(1).equals(arr_airport)&&vector.get(4).equals(de_date)) {
                	System.out.println("\t"+vector.get(6)+"   "+vector.get(0)+"-"+vector.get(1)+"    "+vector.get(2)+" "+vector.get(3)+"   "+vector.get(4)+"  "+vector.get(5)+"    "+vector.get(7)+"     "+vector.get(8)+"      "+vector.get(9)+"      "+vector.get(10));
                    System.out.println();
                    scheduled_flight++;
                }
            }
	    	if(scheduled_flight==0)
	    	{
	    		System.out.println("\tFlights are not available .Sorry :( ");
	    	}
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(scheduled_flight==0)
    	{
    		return false;
    	}
        return true;
	}
	public void get_symbols() {
		System.out.println();
    	System.out.println("\t\t\t\t       ------ AIRPORT SYMBOLS ------");
    	System.out.println();
    	System.out.println();
    	System.out.println("\tSYMBOL  | AIRPORT ");
    	System.out.println("\t-----------------");
    	System.out.println();
    	System.out.println("\tHYD     | HYDERABAD ");
    	System.out.println("\tCHN     | CHENNAI ");
    	System.out.println("\tDLH     | DELHI ");
    	System.out.println("\tJAI     | JAIPUR ");
    	System.out.println("\tBHI     | BIHAR ");
    	System.out.println("\tPDO     | PUDUCHERRY ");
    	System.out.println("\tMDY     | MADHYA PRADESH ");
    	System.out.println("\tMLY     | MALYASIA ");
    	System.out.println("\tNWY     | NEW YORK ");
    	System.out.println("\tCLF     | CALFORNIA");
	}
	public void cancellation() throws IOException {
		Scanner sc= new Scanner(System.in);
		System.out.println();
    	System.out.println("\t\t\t\t       ------ CANCELLATION ------");
    	System.out.println();
    	String flight_code,de_date,de_time,cancel,flight_class;
    	System.out.print("\tEnter flight code you want to cancel : ");
		flight_code=sc.next();
		System.out.println();
		System.out.print("\tEnter flight depature date : ");
		de_date=sc.next();
		System.out.println();
		System.out.print("\tEnter  depature time : "); 
		de_time=sc.next();
		System.out.println();
		System.out.print("\tEnter your flight_class : "); 
		flight_class=sc.next();
		System.out.println();
		System.out.print("\tAre you sure ? Do you want to cancel your booking ? (Yes / No) : ");
		cancel=sc.next();
		System.out.println();
		boolean correct=false;
		if(cancel.equals("Yes")) {
			try {
				File inputFile = new File("Userdata.txt");
				File tempFile = new File("myTempFile.txt");
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
				Scanner sc1 = new Scanner(inputFile);
				String lineToRemove = "";
				while(sc1.hasNextLine()){
					Vector<String> vector= new Vector<String>();
					String line = sc1.nextLine();
					String dummy = "";
					for(int i=0;i<line.length();i++) {
						if(line.charAt(i)==' ') {
							vector.add(dummy);
							dummy="";
						}
						else {
							dummy+=line.charAt(i);
						}
					}
					if(vector.get(6).equals(flight_code)&&vector.get(2).equals(de_time)&&vector.get(4).equals(de_date)&&vector.get(7).equals(flight_class)) {
						lineToRemove=line;
						correct=true;
					}
				}
				if(correct==true) {
					String currentLine;
					while((currentLine = reader.readLine()) != null) {
						if(currentLine.equals(lineToRemove)) 
						continue;
						writer.write(currentLine+"\n");
					}
					writer.close(); 
					reader.close(); 
					BufferedWriter writer_two = new BufferedWriter(new FileWriter(inputFile));
					BufferedReader reader_two = new BufferedReader(new FileReader(tempFile));
					PrintWriter delete = new PrintWriter(inputFile);
					delete.print("");
					String currentLine_two;
					while((currentLine_two = reader_two.readLine()) != null) {
						writer_two.write(currentLine_two+"\n");
					}
					delete.close();
					writer_two.close(); 
					reader_two.close(); 
					PrintWriter delete_two = new PrintWriter(tempFile);
					delete_two.print("");
					delete_two.close();
					System.out.println();
					System.out.println("\tYour cancellation is successfully done ! Money will be refunded soon !");
				}
				else {
					System.out.println("\tFlight not found !");
				}
			}
			catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		}
		else {
			System.out.println("\tCancellation is not done !! Enjoy your ride :)");
		}
	}

}