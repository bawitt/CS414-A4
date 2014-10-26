package a4.application;

//import java.util.Date;
import org.joda.time.*;

public class Ticket {
	int id;
	DateTime enterDate;
	double ticketStandardRate;
	double ticketFlatRate;
	DateTime paymentDate;
	
	public Ticket(int i, Rate r){
		id = i;
		enterDate = new DateTime();
		ticketStandardRate = r.getStandardRate();
		ticketFlatRate = r.getFlatRate();
	}
	public Ticket(){
	}
	
	//hours from entry until current time
	public int getDurationHours(){  
		paymentDate = new DateTime();
		System.out.println(id);
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
	public double getTicketFlatRate(){
		return ticketFlatRate;
	}
}
