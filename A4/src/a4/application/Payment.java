package a4.application;

import java.util.Date;
//import java.util.Calendar;

public class Payment {
	PaymentType paymentType;
	double amountDue;
	Date paymentDate;
	Date enterDate;
	int duration;
	Ticket ticket;
	
	public Payment(PaymentType p, Ticket t){
		paymentType = p;
		ticket = t;
		Date paymentDate = new Date();
	}
	
	public double getAmountDue(){ //set to correct num decimals
		enterDate = ticket.getDate();
		duration = calcDuration(enterDate, paymentDate);
		amountDue = duration * ticket.getTicketRate();
		return amountDue;
	}
	
	public void makePayment(){
		if(paymentType==PaymentType.electronic){
			CashPayment cp = new CashPayment(amountDue);
		}
		if(paymentType==PaymentType.cash){
			ElectronicPayment ep = new ElectronicPayment(amountDue);
		}
	}
	
	public int calcDuration(Date enterDate, Date paymentDate){//needs work
		return duration;
	}
}
