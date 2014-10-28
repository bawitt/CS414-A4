package a4.application;

public class CashPayment extends Payment{
	private double amountDue;
	private double change;
	private double paymentAmount;
	
	public CashPayment(double ad, double pa){
		super(ad, PaymentType.cash);
		amountDue = ad;
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
