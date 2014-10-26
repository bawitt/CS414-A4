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
	boolean isFlatRate = false;
	
	public Payment(Ticket t){
		isFlatRate = false;
		paymentDate = new Date();
		ticket = t;
		duration = ticket.getDurationHours();
		standardRate = ticket.getTicketStandardRate();
		amountDue = duration * standardRate;
	}
	public Payment(Rate r){
		isFlatRate = true;
		paymentDate = new Date();
		flatRate = r.getFlatRate();
		amountDue = flatRate;
	}
	public double getAmountDue(){
		return amountDue;
	}
	public Ticket getPaymentTicket(){
		return ticket;
	}
	public boolean getIsFlatRate(){
		return isFlatRate;
	}
	public Date getPaymentDate(){
		return paymentDate;
	}
}
