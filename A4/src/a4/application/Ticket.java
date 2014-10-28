package a4.application;

//import java.util.Date;
import org.joda.time.*;

public class Ticket {
	private int id;
	private DateTime enterDate;
	private double ticketStandardRate;
	private DateTime paymentDate;
	private int duration;
	
	public Ticket(int i, Rate r){
		id = i;
		enterDate = new DateTime();
		ticketStandardRate = r.getStandardRate();
	}
	public Ticket(){
		id = -1;
	}
	//hours from entry until current time
	public int getDurationHours(){  
		paymentDate = new DateTime();
		Hours hoursInGarage = Hours.hoursBetween(enterDate, paymentDate);
		return (hoursInGarage.getHours() + 1);
	}
	public int getID(){
		return id;
	}
	public DateTime getEnterDate(){
		return enterDate;
	}
	public double getTicketStandardRate(){
		return ticketStandardRate;
	}
	public double getAmountDue(){
		duration = getDurationHours();
		return (duration * getTicketStandardRate());
	}
}
