package a4.application;

import java.util.Date;

public class Ticket {
	int id;
	Date enterDate;
	double ticketRate;
	
	public Ticket(int i, Rate r){
		id = i;
		Date enterDate = new Date();
		ticketRate = r.getRate();
	}
	
	public int getID(){
		return id;
	}
	public Date getDate(){
		return enterDate;
	}
	public double getTicketRate(){
		return ticketRate;
	}
}
