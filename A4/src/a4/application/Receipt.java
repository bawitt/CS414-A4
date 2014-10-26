package a4.application;

import java.util.Date;

public class Receipt {
	Date paymentDate;
	double amount;
	
	public Receipt(Payment pay){
		paymentDate = pay.getPaymentDate();
		amount = pay.getAmountDue();
	}
	
	public void printReceipt(){
		System.out.println("Thank you for your business.\nDate: "+paymentDate+"\nTotal: $"+amount);
	}
}
