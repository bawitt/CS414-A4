package a4.application;

//import org.joda.time.*;
import java.util.Date;
//import java.util.Calendar;

public class Payment {
	private PaymentType paymentType;
	private double amountDue;
	private double originalAmountDue;
	private Date paymentDate;
	
	public Payment(double ad, PaymentType pt){
		paymentDate = new Date();
		paymentType = pt;
		originalAmountDue = ad;
		amountDue = ad;
	}

	public double getAmountDue(){
		return amountDue;
	}
	public Date getPaymentDate(){
		return paymentDate;
	}
	public PaymentType getPaymentType(){
		return paymentType;
	}
	public double getOriginalAmountDue(){
		return originalAmountDue;
	}
}
