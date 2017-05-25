/**
 * @author Vadym. Email: vadyavl@gmail.com
 * @since 1.0
 */
package ua.edu.kpi.logic;

/**
 * Describe country of Europe.
 * @author Vadym
 * @since 1.0
 */
public class Country {
	
	private String name;				// Name of country
	private int left, down, right, up;  // LEFT-DOWN and RIGHT-UP coordinates cities
	private int endDay = 0;				// The day when the city received all the coins
	private boolean isCompleted = false;// A check mark means that the completion of the country
	
	/**
	 * 
	 * @param name Name of country
	 * @param xl LEFT
	 * @param yd DOWN
	 * @param xr RIGHT
	 * @param yu UP
	 */
	public Country(String name, int xl, int yd, int xr, int yu){
		this.name = name;
		this.left = xl;
		this.down = yd;
		this.right = xr;
		this.up = yu;
	}

	/**
	 * This method need array of cities and current day.
	 * In first version of program this method was not. 
	 * This was explained in order to avoid transmission matrix and Int value unnecessary method.
	 * @param cities
	 * @param day
	 */
	public void checkCountryOnComplete(City[][] cities, int day){
		boolean completed = true;								// Can you believe the city completed
		
		CyclesOfCheckCities :									// Mark for break inside for-for
		for(int i=down-1; i<up; i++){							// Go through all the cities
			for(int j=left-1; j<right; j++){
				if(	cities[i][j].getCountry().equals(this) && 	// If we found necessary city
					!cities[i][j].isCompleted()){				// and it's not completed
					completed = false;		
					break CyclesOfCheckCities;					// Go out
				}
			}
		}
		
		if(!isCompleted && completed){	// If all cities are completed
			isCompleted = completed;	// Mark country as completed
			endDay = day;				// and save this day
		}
	}
	
	/**
	 * 
	 * @return country is completed?
	 */
	public boolean isCompleted() {
		return isCompleted;
	}
	
	/**
	 * 
	 * @return name of country.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return End/Final day.
	 */
	public int getEndDay() {
		return endDay;
	}
}