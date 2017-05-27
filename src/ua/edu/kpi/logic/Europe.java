/**
 * @author Vadym. Email: vadyavl@gmail.com
 * @since 1.0
 */
package ua.edu.kpi.logic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Europe - The class that contains a list of countries and their settlements. Implements the logic of coins spread across Europe.
 * @author Vadym
 * @since 1.0
 */
public class Europe {

	/** Width and Height of Europe. */
	public final static int Width = 10, Height = 10;
	/** The same as the number of countries. */
	public static int CountCoinTypes;

	private ArrayList<Country> countries; 	// List of all countries of Europe.
	private City[][] cities; 				// Array of all cities of Europe.
	private boolean completed = false;		// End of algorithm
	private int day = 1;					// Current day/iteration of algorithm
	
	/**
	 * Constructor of Europe
	 * @param data String with information about countries
	 */
	public Europe(String data) {
		cities = new City[Width][Height];
		countries = new ArrayList<>();
		
		String[] args = data.split("\n");
		CountCoinTypes = Integer.parseInt(args[0]);

		for(int c = 1; c <= CountCoinTypes; c++) {
			String[] cArgs = args[c].split(" ");
			int left = Integer.parseInt(cArgs[1]), down = Integer.parseInt(cArgs[2]), 
				right = Integer.parseInt(cArgs[3]), up = Integer.parseInt(cArgs[4]);
			Country country = new Country(cArgs[0], left, down, right, up);
			countries.add(country);
			
			for(int i = down-1; i < up; i++){
				for(int j = left-1; j < right; j++){
					cities[i][j] = new City(country);
				}
			}
		}
	}
	
	/**
	 * Make next iteration. Iteration = one day.
	 */
	public void nextDay(){
		// Coins Diffusion foreach neighbor send coins
		for(int i=0; i<Height; i++){
			for(int j=0; j<Width; j++){
				if(cities[i][j]!=null){
					if(i-1>=0 && cities[i-1][j]!=null) {
						cities[i-1][j].putCoins(cities[i][j].getCoins());
					}
					if(j+1<Width && cities[i][j+1]!=null){
						cities[i][j+1].putCoins(cities[i][j].getCoins());
					}
					if(i+1<Height && cities[i+1][j]!=null){
						cities[i+1][j].putCoins(cities[i][j].getCoins());
					}
					if(j-1>=0 && cities[i][j-1]!=null){
						cities[i][j-1].putCoins(cities[i][j].getCoins());
					}
				}
			}
		}
		
		// Check the country at the completed
		for(Country country: countries){
			country.checkCountryOnComplete(cities, day);
		}
		
		// Check conditions completion
		completed = true;
		
		for(Country country: countries){
			if(!country.isCompleted()){
				completed = false;
				break;
			}
		}
		
		// Next day
		if(!completed){
			day++;
		}
	}
	
	/**
	 * The output results of the program in console.
	 */
	public void showResult(){
		countries.sort(comparator);
		
		for(Country country : countries){
			System.out.println("\t" + country.getName() + ": " + country.getEndDay());
		}
	}
	
	/**
	 * Show Europe square in console.
	 */
	public void showInConsole(){
		for(int i=Height-1; i>=0; i--){
			for(int j=0; j<Width; j++){
				System.out.print(cities[i][j] != null ? cities[i][j] : " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @return The end of the algorithm. true - coins spread all cities.
	 */
	public boolean isCompleted() {
		return completed;
	}
	
	/**
	 * Comparator for sorting method. The result should be sorted EndDay / FinalDay.
	 * EndDay / FinalDay - the day when in every city of the country will all coins.
	 */
	private Comparator<Country> comparator = new Comparator<Country>() {
		
		@Override
		public int compare(Country o1, Country o2) {
			return o1.getEndDay() - o2.getEndDay();
		}
	};
}
