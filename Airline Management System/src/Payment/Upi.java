package Payment;

import java.util.Scanner;

public class Upi extends payment {
	String Upi_id;
	private String Upi_pin;
	public Upi(String name, String phone_num, String email, String price,String Upi_id,String Upi_pin) {
		super(name, phone_num, email, price);
		this.Upi_id=Upi_id;
		this.Upi_pin=Upi_pin;
	}
	public void payment() {
		notification();
	}
}
