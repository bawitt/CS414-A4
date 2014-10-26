package a4.application;

public class ElectronicPayment{
	int accountNum;
	double amountDue;
	
	public ElectronicPayment(Payment pay, int act){;
		accountNum = act;
		amountDue = pay.getAmountDue();	
	}
	
}
