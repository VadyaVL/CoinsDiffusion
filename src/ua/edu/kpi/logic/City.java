/**
 * @author Vadym. Email: vadyavl@gmail.com
 * @since 1.0
 */
package ua.edu.kpi.logic;

import java.util.ArrayList;

/**
 * Describe city of country of Europe.
 * @author Vadym
 * @since 1.0
 */
public class City {

	public final static int INITIAL_COUNT_OF_COINS = 1_000_000;	// One million of coin each type
	public final static int ONE_COIN_PER_1000 = 1000;			// Get one coin from one full 1000
	
	private Country country;			// The city belongs
	private ArrayList<Coin> coins;		// List of all coins
	private boolean completed = false;	// A check mark means that the completion of the city
	
	/**
	 * 
	 * @param country The city belongs
	 */
	public City(Country country){
		this.country = country;
		coins = new ArrayList<Coin>();
		coins.add(new Coin(country, INITIAL_COUNT_OF_COINS));
		
		if(!completed && (coins.size() == Europe.CountCoinTypes)){ // Check end of algorithm for case with one country 
			completed = true;
		}
	}
	
	/**
	 * 
	 * @return count of each coins type
	 */
	public ArrayList<Coin> getCoins(){
		ArrayList<Coin> coinsGorSend = new ArrayList<>();
		
		for(Coin coin : coins){
			int countCoin = coin.getCount()/1000;
			if(countCoin == 0){
				continue;
			}
			coinsGorSend.add(new Coin(coin.getCountry(), countCoin));
			coin.setCount(coin.getCount() - countCoin);
		}
		
		return coinsGorSend;
	}
	
	/**
	 * 
	 * @param the numbers of received coins
	 */
	public void putCoins(ArrayList<Coin> newCoins){
		for(Coin newCoin : newCoins){
			Coin find = null;
			
			for(Coin coin : coins){
				if(coin.getCountry().equals(newCoin.getCountry())){
					find = coin;
					break;
				}
			}
			
			if(find != null){
				find.setCount(find.getCount() + newCoin.getCount());
			}
			else {
				coins.add(newCoin);
			}
		}
		
		if(!completed && (coins.size() == Europe.CountCoinTypes)){
			completed = true;
		}
	}
	
	/**
	 * 
	 * @return Country/type of coins
	 */
	public Country getCountry() {
		return country;
	}
	
	/**
	 * 
	 * @return city is completed?
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Show city as first letter from country name.
	 */
	@Override
	public String toString(){
		return country.getName().substring(0, 1);
	}
	
}
