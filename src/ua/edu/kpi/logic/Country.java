package ua.edu.kpi.logic;

public class Country {
	
	private String name;
	private int xld, yld, xru, yru;	// LEFT-DOWN and RIGHT-UP COORDS OF CITIES
	private int endDay = 0;

	private boolean isCompleted = false;
	
	public Country(String name, int xld, int yld, int xru, int yru){
		this.name = name;
		this.xld = xld;
		this.yld = yld;
		this.xru = xru;
		this.yru = yru;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getName() {
		return name;
	}
	
	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int bestDay) {
		this.endDay = bestDay;
	}

	public int getXld() {
		return xld;
	}

	public int getYld() {
		return yld;
	}

	public int getXru() {
		return xru;
	}
	
	public int getYru() {
		return yru;
	}
}
