package reservation;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Admin {
	public void create_flight_record() {
		Scanner sc = new Scanner(System.in);
		String de_airport, arr_airport, de_time, arr_time, de_date, arr_date, code, eco_price, busi_price, inter_do ;
		int no_of_seats_eco, no_of_seats_busi ;
		System.out.print("\tEnter depature airport : "); 
		de_airport=sc.next();
		System.out.println();
		System.out.print("\tEnter arrival airport : "); 
		arr_airport=sc.next();
		System.out.println();
		System.out.print("\tEnter  depature time : "); 
		de_time=sc.next();
		System.out.println();
		System.out.print("\tEnter arrival time : "); 
		arr_time=sc.next();
		System.out.println();
		System.out.print("\tEnter depature date : "); 
		de_date=sc.next();
		System.out.println();
		System.out.print("\tEnter arrival date : "); 
		arr_date=sc.next();
		System.out.println();
		System.out.print("\tEnter flight code : "); 
		code=sc.next();
		System.out.println();
		File myFile = new File("flightdata.txt");
        try {
            Scanner sc1 = new Scanner(myFile);
	    	while(sc1.hasNextLine()){
            	Vector<String> vector2= new Vector<String>();
                String line = sc1.nextLine();
                if(!line.isEmpty()) {
                String dummy = "";
                for(int i=0;i<line.length();i++) {
                	if(line.charAt(i)==' ') {
                		vector2.add(dummy);
                		dummy="";
                	}
                	else {
                		dummy+=line.charAt(i);
                	}
                }
                if(vector2.get(6).equals(code)) {
                	System.out.println("\t\t Flight Record already exists ensure the timings are different");
                	System.out.println();
                }
                }
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		System.out.print("\tEnter economy ticket price : "); 
		eco_price=sc.next();
		System.out.println();
		System.out.print("\tEnter business ticket price : "); 
		busi_price=sc.next();
		System.out.println();
		System.out.print("\tEnter Internation / Domestic flight : "); 
		inter_do=sc.next();
		System.out.println();
		System.out.print("\tEnter no of seats available in Economy : "); 
		no_of_seats_eco=sc.nextInt();
		System.out.println();
		System.out.print("\tEnter no of seats available in Business : "); 
		no_of_seats_busi=sc.nextInt();
		System.out.println();
		try {
			FileWriter fileWriter = new FileWriter("flightdata.txt",true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
	        bw.write(de_airport+" "+arr_airport+" "+de_time+" "+arr_time+" "+de_date+" "+arr_date+" "+code+" "+eco_price+" "+busi_price+" "+no_of_seats_eco+" "+no_of_seats_busi+" "+"\n");
	        bw.close();
			System.out.println("\t\t Data successfully added");
		}
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void display_flight_record() {
		 File myFile = new File("flightdata.txt");
	        try {
	            Scanner sc = new Scanner(myFile);
	            System.out.println();
		    	System.out.println("\t\t\t\t       ------ FLIGHT RECORDS ------");
		    	System.out.println();
		    	System.out.println();
		    	System.out.println("\tCODE  | DEP-ARR |     TIME     |          DATE          | EPRICE | BPRICE | ESEATS | SEATS");
		    	System.out.println("\t------------------------------------------------------------------------------------------");
		    	System.out.println();
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
	                System.out.println("\t"+vector.get(6)+"   "+vector.get(0)+"-"+vector.get(1)+"    "+vector.get(2)+" "+vector.get(3)+"   "+vector.get(4)+"  "+vector.get(5)+"    "+vector.get(7)+"     "+vector.get(8)+"      "+vector.get(9)+"      "+vector.get(10));
	                System.out.println();
	            }
	        } 
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	}
	public void customer_booking(String flight_class,String flight_code,String de_time,String de_date,String no_of_seats) {
		File myFile = new File("flightdata.txt");
		String flight_d="";
		String flight_a="";
		try {
			int counter=0;
			FileWriter fileWriter = new FileWriter("Userdata.txt",true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			Scanner sc1 = new Scanner(myFile);
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
	            		flight_d=vector.get(0);
	            		flight_a=vector.get(1);
	            		if(flight_class.equals("Economy")) {
	            			bw.write(vector.get(0)+" "+vector.get(1)+" "+vector.get(2)+" "+vector.get(3)+" "+vector.get(4)+" "+vector.get(5)+" "+vector.get(6)+" "+flight_class+" "+vector.get(7)+" "+no_of_seats+" "+"\n");
	            		}
	            		else {
	            			bw.write(vector.get(0)+" "+vector.get(1)+" "+vector.get(2)+" "+vector.get(3)+" "+vector.get(4)+" "+vector.get(5)+" "+vector.get(6)+" "+flight_class+" "+vector.get(8)+" "+no_of_seats+" "+"\n");
	            		}
	            		counter++;
	            	}
	            }
	        bw.close();
			if(counter==0) {
				System.out.println("Enter correct flight details ");
			}
			else {
				System.out.println("\tCongratulations your booking is successfull,");
				System.out.println("\tyour flight "+flight_code+" from "+flight_d+" to "+flight_a+" with "+no_of_seats+" passengers will take off on "+de_date);
				System.out.println("\thave a safe  and happy journey !");
				System.out.println("\tQATAR AIRWAYS");
			}
		}
		catch (IOException e) {
            e.printStackTrace();
        }
}
}
