package a4.application;

import java.text.DecimalFormat;
import java.util.Date;

public class Receipt {
	private Date paymentDate;
	private PaymentType paymentType;
	private double amount;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public Receipt(Payment pay){
		paymentDate = pay.getPaymentDate();
		amount = pay.getOriginalAmountDue();
		paymentType = pay.getPaymentType();
	}
	
	public void printReceipt(){
		System.out.println("\nReceipt: \nThank you for your business.\nDate: "+paymentDate+
				"\nTotal: $" + df.format(amount) + "\nPayment Type: " + paymentType + "\n");
	}
}
