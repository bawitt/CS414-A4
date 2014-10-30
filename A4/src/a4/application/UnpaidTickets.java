package a4.application;

public class UnpaidTickets {
	private String custName;
	private String custAddress;
	private String custPhone;
	private Ticket unpaidTicket;
	private String unpaidTicketString;
	
	public UnpaidTickets(String cn, String ca, String cp, Ticket up){
		custName = cn;
		custAddress = ca;
		custPhone = cp;
		unpaidTicket = up;
	}
	public String toString(){
		unpaidTicketString = "\nName: " + custName + "\nAddress: " + custAddress 
				+ "\nPhone #: " + custPhone + "\nTicket ID: " + unpaidTicket.getID() + "\n";
		return unpaidTicketString;
	}
}
