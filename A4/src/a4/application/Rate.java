package a4.application;

public class Rate {
	private double rate;
	private double flatRate;
	
	public Rate(double r, double fr){
		rate = r;
		flatRate = fr;
	}
	public Rate(){
		rate = 0;
		flatRate = 0;
	}
	
	public double getStandardRate(){
		return rate;
	}
	public void setStandardRate(double r){
		rate = r;
	}
	
	public double getFlatRate(){
		return flatRate;
	}
	public void setFlatRate(double r){
		flatRate = r;
	}
}
