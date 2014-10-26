package a4.application;

public class CashPayment{
	double amountDue;
	double change;
	double paymentAmount;
	
	public CashPayment(Payment pay, double pa){
		amountDue = pay.getAmountDue();
		paymentAmount = pa;
		change = 0;
		makeInitialCashPayment();	
	}
	
	public void makeInitialCashPayment(){
		amountDue = amountDue - paymentAmount;
		if(amountDue<0) change = amountDue *-1;
	}
	public void makePostCashPayment(double paymentAmount){
		amountDue = amountDue - paymentAmount;
		if(amountDue<0) change = amountDue *-1;
	}
	public double getAmountDue(){
		return amountDue;
	}
	
	public double getChange(){
		return change;
	}
}
