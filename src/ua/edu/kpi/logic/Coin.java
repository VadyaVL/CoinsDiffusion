package ua.edu.kpi.logic;

public class Coin {
	
	private Country country;
	private int count;
	
	public Coin(Country country, int count){
		setCountry(country);
		setCount(count);
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country type) {
		this.country = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
