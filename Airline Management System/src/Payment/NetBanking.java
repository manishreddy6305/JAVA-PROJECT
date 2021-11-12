package Payment;

import java.util.Scanner;

public class NetBanking extends payment {
	
	public NetBanking(String name, String phone_num, String email, String price) {
		super(name, phone_num, email, price);
	}

	public void payment() {
		Scanner sc = new Scanner(System.in);
		int select;
		String Bank;
		System.out.print("\n\tMENU");
       	System.out.print("\n\t1.SBI");
       	System.out.print("\n\t2.HDFC");
       	System.out.print("\n\t3.KOTAK");
        System.out.print("\n\t4.ICICI");
       	System.out.print("\n\t5.UBI"); 
       	System.out.print("\n\t6.exit");
       	System.out.println();
       	System.out.println();
       	System.out.print("	Select your option (1/2/3/4/5/6): ");
       	select=sc.nextInt();
       	while(select> 6|| select<1){
            System.out.println("\n\t\tInvalid Choice..");
            System.out.println();
            System.out.print("\tPlease select your choice correctly(1/2/3/4/5/6): ");
            select=sc.nextInt();
       	 }
       	 System.out.println();
       	 switch(select) {
       	 	case 1:
       	 	case 2:
       	 	case 3:
       	 	case 4:
       	 	case 5:
   	 				confirm_payment();
       	 	case 6:
       	 			break;
       	 }
	}
}
