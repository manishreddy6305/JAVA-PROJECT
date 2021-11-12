package Payment;

public class Card extends payment {
	String card_name;
	String card_num;
	private String card_cvv;
	String card_expiry;
	String card_type;
	public Card(String name, String phone_num, String email, String price,String card_name,String card_num,String card_type,String card_expiry,String card_cvv) {
		super(name, phone_num, email, price);
		this.card_name=card_name;
		this.card_num=card_num;
		this.card_cvv=card_cvv;
		this.card_expiry=card_expiry;
		this.card_type=card_type;
	}
	public void payment() {
		notification();
	}
}
