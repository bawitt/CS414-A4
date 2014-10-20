package a4.application;

public class CashPayment {
	double amountDue;
	double change;
	double paymentAmount;
	
	public CashPayment(double a, double p){
		amountDue = a;
		paymentAmount = p;
	}
	
	public void makeCashPayment(){
		
	}
	
	public double getChange(){
		return change;
	}
}
