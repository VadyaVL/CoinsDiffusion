package ua.edu.kpi.logic;

import java.util.ArrayList;

public class City {
	
	private Country country;
	private ArrayList<Coin> coins;
	private boolean completed = false;
	
	public City(Country country){
		setCountry(country);
		coins = new ArrayList<Coin>();
		coins.add(new Coin(country, 1000000));
		
		if(!completed && coins.size() == Europe.CountCoinTypes){
			completed = true;
		}
	}

	public ArrayList<Coin> getCoins(){
		ArrayList<Coin> coinsGorSend = new ArrayList<>();
		
		for(Coin coin : coins){
			int countCoin = coin.getCount()/1000;	//  Цілочисельне ділення
			if(countCoin == 0){
				continue;
			}
			coinsGorSend.add(new Coin(coin.getCountry(), countCoin));
			coin.setCount(coin.getCount() - countCoin);
		}
		
		return coinsGorSend;
	}
	
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
		
		if(!completed && coins.size() == Europe.CountCoinTypes){
			completed = true;
		}
	}
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean areCompleted) {
		this.completed = areCompleted;
	}

	@Override
	public String toString(){
		return country.getName().substring(0, 1);
	}
	
}
