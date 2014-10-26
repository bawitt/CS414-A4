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
	Employee emp;
	Set<Ticket> activeTickets = new HashSet<Ticket>();
	Set<Ticket> paidTickets = new HashSet<Ticket>();
	Set<Employee> users = new HashSet<Employee>();
	
	public Garage(){
		createEmployee("bwitt", 1234);
		capacitySign = new Sign();
		entryGate = new Gate(GateType.entrance);
		exitGate = new Gate(GateType.exit);
		garageRate = new Rate(4, 50);  //update hard value
		garageSpaces = new Spaces(20,0);  //update hard value
		ticketCount = 0;
	}
	
	public void updateSignStatus(){
		capacitySign.refreshSign(garageSpaces);
	}
	public void updateGarageSpaces(int s){
		garageSpaces.setNumSpaces(s); 
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
			entryGate.openGate();
			try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
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
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		exitGate.closeGate();
		activeTickets.remove(ticket);
		paidTickets.add(ticket);
		updateSignStatus();
	}
	
	public void exitGarage(){
		garageSpaces.decExit();	
		exitGate.openGate();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		exitGate.closeGate();
		updateSignStatus();
	}
	
	public void createEmployee(String un, int pn){
		Employee emp = new Employee(un, pn);
		//System.out.println(emp.getUsername());
		users.add(emp);
	}
	
	public Rate getGarageRate(){
		return garageRate;
	}
	
	
}
