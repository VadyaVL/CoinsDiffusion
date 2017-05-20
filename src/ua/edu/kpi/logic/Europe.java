package ua.edu.kpi.logic;

import java.util.ArrayList;
import java.util.Comparator;

public class Europe {

	/** Width and Height of Europe. */
	public static int N = 10, M = 10;
	/** The same as the number of countries. */
	public static int CountCoinTypes;

	private ArrayList<Country> countries; 	// List of all countries of Europe.
	private City[][] cities; 				// Array of all cities of Europe.
	private boolean completed = false;		// Ñompletion flag
	private int day = 1;					// Current day
	
	public Europe(String data) {
		cities = new City[N][M];
		countries = new ArrayList<>();
		
		String[] args = data.split("\n");
		CountCoinTypes = Integer.parseInt(args[0]);

		for(int c=1; c<=CountCoinTypes; c++) {
			String[] cArgs = args[c].split(" ");
			Country country = new Country(cArgs[0], Integer.parseInt(cArgs[1]), Integer.parseInt(cArgs[2]), 
													Integer.parseInt(cArgs[3]), Integer.parseInt(cArgs[4]));
			countries.add(country);
			for(int i=country.getYld()-1; i<country.getYru(); i++){
				for(int j=country.getXld()-1; j<country.getXru(); j++){
					cities[i][j] = new City(country);
				}
			}
		}
	}
	
	public void nextDay(){
		// Coins Diffusion
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				if(cities[i][j]!=null){
					if(i-1>=0 && cities[i-1][j]!=null) {
						cities[i-1][j].putCoins(cities[i][j].getCoins());
					}
					if(j+1<N && cities[i][j+1]!=null){
						cities[i][j+1].putCoins(cities[i][j].getCoins());
					}
					if(i+1<M && cities[i+1][j]!=null){
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
			boolean completed = true;
			
			for(int i=country.getYld()-1; i<country.getYru(); i++){
				for(int j=country.getXld()-1; j<country.getXru(); j++){
					if(cities[i][j].getCountry().equals(country)){
						if(!cities[i][j].isCompleted()){
							completed = false;
						}
					}
				}
			}
			
			if(!country.isCompleted() && completed){
				country.setCompleted(completed);
				country.setEndDay(day);
			}
		}
		
		// Check conditions completion
		completed = true;
		
		for(Country country: countries){
			if(!country.isCompleted()){
				completed = false;
				break;
			}
		}
		
		if(!completed){
			day++;
		}
	}
	
	public void showResult(){
		countries.sort(comparator);
		
		for(Country country : countries){
			System.out.println("\t" + country.getName() + ": " + country.getEndDay());
		}
	}
	
	public void showInConsole(){
		for(int i=M-1; i>=0; i--){
			for(int j=0; j<N; j++){
				System.out.print(cities[i][j] != null ? cities[i][j] : " ");
			}
			System.out.println();
		}
	}
	

	public boolean isCompleted() {
		return completed;
	}
	
	private Comparator<Country> comparator = new Comparator<Country>() {
		
		@Override
		public int compare(Country o1, Country o2) {
			return o1.getEndDay() - o2.getEndDay();
		}
	};
}
