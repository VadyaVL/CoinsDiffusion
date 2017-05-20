package ua.edu.kpi.logic;

public class Country {
	
	private String name;
	private int xld, yld, xru, yru;	// LEFT-DOWN and RIGHT-UP COORDS OF CITIES
	private int endDay = 0;

	private boolean isCompleted = false;
	
	public Country(String name, int xld, int yld, int xru, int yru){
		setName(name);
		setXld(xld);
		setYld(yld);
		setXru(xru);
		setYru(yru);
	}

	@Override
    public boolean equals(Object obj) {
		
		if(obj instanceof Country){
			if(this.name == ((Country)obj).name){
				return true;
			}
		}
		
		return false;
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

	private void setName(String name) {
		this.name = name;
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

	private void setXld(int xld) {
		this.xld = xld;
	}

	public int getYld() {
		return yld;
	}

	private void setYld(int yld) {
		this.yld = yld;
	}

	public int getXru() {
		return xru;
	}

	private void setXru(int xru) {
		this.xru = xru;
	}

	public int getYru() {
		return yru;
	}

	private void setYru(int yru) {
		this.yru = yru;
	}
	
}
