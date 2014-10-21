package a4.application;

//import org.joda.time.*;
import java.util.Date;
//import java.util.Calendar;

public class Payment {
	PaymentType paymentType;
	double amountDue;
	Date paymentDate;
	int duration;
	Ticket ticket;
	double standardRate;
	double flatRate;
	
	public Payment(PaymentType p, Ticket t){
		paymentType = p;
		ticket = t;
		Date paymentDate = new Date();
		duration = ticket.getDurationHours();
		standardRate = ticket.getTicketStandardRate();
		flatRate = ticket.getTicketFlatRate();
	}
	
	public double getStandardAmountDue(){ //set to correct num decimals
		amountDue = duration * standardRate;
		return amountDue;
	}
	public double getFlatRateAmountDue(){
		amountDue = flatRate;
		return amountDue;
	}
	
	/*
	public void makeStandardPayment(){
		if(paymentType==PaymentType.electronic){
			CashPayment cp = new CashPayment(amountDue);
		}
		if(paymentType==PaymentType.cash){
			ElectronicPayment ep = new ElectronicPayment(amountDue);
		}
	}
	*/

}
