package ua.edu.kpi.logic;

public class Coin {
	
	private Country country;
	private int count;
	
	public Coin(Country country, int count){
		setCount(count);
		
		this.country = country;
	}
	
	public Country getCountry() {
		return country;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
