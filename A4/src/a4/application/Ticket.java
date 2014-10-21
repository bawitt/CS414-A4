package a4.application;

//import java.util.Date;
import org.joda.time.*;

public class Ticket {
	int id;
	DateTime enterDate;
	double ticketStandardRate;
	double ticketFlatRate;
	
	public Ticket(int i, Rate r){
		id = i;
		DateTime enterDate = new DateTime();
		ticketStandardRate = r.getRate();
		ticketFlatRate = r.getFlatRate();
	}
	//hours from entry until current time
	public int getDurationHours(){  
		DateTime d = new DateTime();
		Hours hoursInGarage = Hours.hoursBetween(enterDate, d);
		return (hoursInGarage.getHours() + 1);
	}
	
	public int getID(){
		return id;
	}
	public DateTime getDate(){
		return enterDate;
	}
	public double getTicketStandardRate(){
		return ticketStandardRate;
	}
	public double getTicketFlatRate(){
		return ticketFlatRate;
	}
}
