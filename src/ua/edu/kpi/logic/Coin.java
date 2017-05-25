/**
 * @author Vadym. Email: vadyavl@gmail.com
 * @since 1.0
 */
package ua.edu.kpi.logic;

/**
 * Class describe coin each country of Europe.
 * @author Vadym
 *
 */
public class Coin {
	
	private Country country;	// Made in
	private int count;			// Count of coins of current exemplar
	
	/**
	 * 
	 * @param country producing country
	 * @param count initial value
	 */
	public Coin(Country country, int count){
		setCount(count);
		this.country = country;
	}
	
	/**
	 * @return country/type of coin
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @return current count of coin
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @param new count of coin
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
