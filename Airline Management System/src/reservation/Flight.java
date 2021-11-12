package reservation;

public class Flight {
	private String depature_airport;
	private String arrival_airport;
	private String depature_time;
	private String arrival_time;
	private String depature_date;
	private String arrival_date;
	private String code;
	private String economy_price;
	private String business_price;
	private int no_of_seats_economy;
	private int no_of_seats_business;
	public String getDepature_airport() {
		return depature_airport;
	}
	public String getArrival_airport() {
		return arrival_airport;
	}
	public String getDepature_time() {
		return depature_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public String getDepature_date() {
		return depature_date;
	}
	public String getArrival_date() {
		return arrival_date;
	}
	public String getCode() {
		return code;
	}
	public String getEconomy_price() {
		return economy_price;
	}
	public String getBusiness_price() {
		return business_price;
	}
	public int getNo_of_seats_economy() {
		return no_of_seats_economy;
	}
	public int getNo_of_seats_business() {
		return no_of_seats_business;
	}
}
