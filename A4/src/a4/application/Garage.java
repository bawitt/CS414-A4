package a4.application;

//import org.joda.time.DateTime;
import java.util.*;

public class Garage {
	private Sign capacitySign;
	private Gate entryGate;
	private Gate exitGate;
	private Rate garageRate;
	private Spaces garageSpaces;
	private int ticketCount;
	private Employee emp;
	private Set<Ticket> activeTickets = new HashSet<Ticket>();
	private Set<Ticket> paidTickets = new HashSet<Ticket>();
	private Set<Employee> users = new HashSet<Employee>();
	
	public Garage(){ //hard values exist for initial object creation
		createEmployee("bwitt", 1234);
		capacitySign = new Sign();
		entryGate = new Gate(GateType.entrance);
		exitGate = new Gate(GateType.exit);
		garageRate = new Rate(4, 50);  
		garageSpaces = new Spaces(20,0);  
		ticketCount = 0;
	}
	
	public void updateSignStatus(){
		capacitySign.refreshSign(garageSpaces);
	}
	public void updateGarageSpaces(int numSpaces){
		garageSpaces.setNumSpaces(numSpaces); 
		updateSignStatus();
	}
	public void updateGarageStandardRate(double r){
		garageRate.setStandardRate(r);
	}
	public void updateGarageFlatRate(double r){
		garageRate.setFlatRate(r);
	}
	public void issueTicket() {
		if(capacitySign.getSignStatus()==SignStatus.vacancy){
			ticketCount = ticketCount +1;
			Ticket ticket = new Ticket(ticketCount, garageRate);
			garageSpaces.incEnter();
			activeTickets.add(ticket);
			System.out.println("Your ticket ID is: "+ ticket.getID() + "\n");
			entryGate.openGate();
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			entryGate.closeGate();
			updateSignStatus();
		}
		else {
			System.out.println("Garage is currently full");
		}
	}
	public Ticket getTicketFromList(int id){
		for(Ticket ticket : activeTickets){
			if(ticket.getID()==id){
				return ticket;
			}
		}
		Ticket ticket= new Ticket();
		return ticket;
	}
	public Employee getEmployeeFromList(String un){
		for(Employee emp : users){
			if(emp.getUsername().equals(un)){
				return emp;
			}
		}
		Employee emp = new Employee();
		return emp;
	}
	public boolean authorizeUser(String un, int pn){
		boolean success = false;
		emp = getEmployeeFromList(un);
		success = emp.isApproved(pn);
		return success;
	}
	public void exitGarage(Ticket ticket){
		garageSpaces.decExit();	
		exitGate.openGate();
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		exitGate.closeGate();
		activeTickets.remove(ticket);
		paidTickets.add(ticket);
		updateSignStatus();
	}
	public void exitGarage(){
		garageSpaces.decExit();	
		exitGate.openGate();
		try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}
		exitGate.closeGate();
		updateSignStatus();
	}
	public void createEmployee(String un, int pn){
		Employee emp = new Employee(un, pn);
		users.add(emp);
	}
	public Rate getGarageRate(){
		return garageRate;
	}
	public double getGarageFlatRate(){
		return garageRate.getFlatRate();
	}
	public void showsSpaceStatus(){
		System.out.println("Status: " + capacitySign.getSignStatus()
				+ "\nTotal Spaces: " + garageSpaces.getNumSpaces()
				+ "\nUsed Spaces: " + garageSpaces.getUsedSpaces() + "\n");
	}	
}
