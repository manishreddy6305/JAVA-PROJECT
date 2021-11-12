package Payment;

import java.util.Scanner;

interface Methods{
   public void confirm_payment();
   public void notification();
}
public class payment implements Methods{
	String name;
	String email;
	String phone_num;
	String price;
	public payment(String name,String phone_num,String email,String price) {
		this.name=name;
		this.email=email;
		this.phone_num=phone_num;
		this.price=price;
	}
	public void confirm_payment() {
		System.out.println("\tAmount to be paid per seat : "+ price);
		Scanner sc =new Scanner (System.in);
		String user_name,password;
		System.out.println();
		System.out.print("\tEnter your user_name : ");
		user_name=sc.next();
		System.out.println();
		System.out.print("\tEnter your password : ");
		password=sc.next();
		System.out.println();
		notification();
	}
	public void notification() {
		System.out.println();
		System.out.println("\t\t\tYour Payment is successfull "+ price +" deducted from your account per seat.");
		System.out.println();
	}
}
