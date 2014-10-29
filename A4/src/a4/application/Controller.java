package a4.application;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Controller {
	private Garage garage = new Garage();
	private Scanner input = new Scanner(System.in);
	//private int choice;
	private int ticketID;
	//private Payment pay;
	private double amountDue;
	//private String userName;
	private DecimalFormat df = new DecimalFormat("0.00");
	private Ticket ticket;
	
	public void pause(){
		System.out.println("Press Enter to continue.");
		try{System.in.read();}
		catch(Exception e){}
	}
	
	public void mainMenu(){
		int mainChoice=0;	
		while (mainChoice !=6){
		System.out.println("Please Select an option: \n1. Enter Garage "
				+ "\n2. Exit Garage \n3. Request Assistance \n4. Employee Login "
				+ "\n5. Capacity Status \n6. Quit");
		mainChoice = input.nextInt();
		switch(mainChoice){
		case 1: garage.issueTicket(); break;
		case 2: exitMenu(); break;
		case 3: System.out.println("Assistance requested"); break;
		case 4: 			
			System.out.println("Enter user name: ");
			String un = input.next(); 
			System.out.println("Enter user pass code: ");
			String pn = input.next();
			boolean loginSuccess = garage.authorizeUser(un, pn);
			if(loginSuccess) {System.out.println("Successful login.\n"); empMenu();}
			else {System.out.println("Login unsuccessful.\n");}
			break;
		case 5: garage.showsSpaceStatus(); break;
		case 6: System.out.println("Exiting..."); break;
		default:
			System.out.println("Invalid selection.\n"); break;
		}
		pause();
		}
	}
	public void exitMenu(){
		int exitChoice = 0;
		//Ticket ticket = new Ticket();
		System.out.println("Please Select an option: \n1. Enter Ticket ID "
				+ "\n2. Flat Rate Payment \n3. Back");
		exitChoice = input.nextInt();
		switch(exitChoice){
		case 1: 
			ticketID = getTicketID();
			ticket = garage.getTicketFromList(ticketID);
			if(ticket.getID()==-1) {System.out.println("Invalid ticket ID.\n"); exitMenu(); break;}
			amountDue = ticket.getAmountDue();
			System.out.println("Amount due: " + df.format(amountDue) + "\n"); 
			paymentMenu(amountDue, ticket, false); break;
		case 2:  
			Ticket ticket = new Ticket();
			amountDue = garage.getGarageFlatRate();
			System.out.println("Amount due: $" + df.format(amountDue) + "\n");
			paymentMenu(amountDue, ticket, true); break;
		case 3: break;
		default:
			System.out.println("Invalid selection.\n");
			exitMenu(); break;
		}
	}

	public void paymentMenu(double amountDue, Ticket ticket, boolean isFlatRate){
		int payChoice = 0;
		System.out.println("Please Select an option: \n1. Cash Payment "
				+ "\n2. Electronic Payment \n3. Back");
		payChoice = input.nextInt();
		switch(payChoice){
		case 1: 
			System.out.println("Please insert cash. Enter amount in USD: ");
			double paymentAmount = input.nextInt();
			CashPayment cp = new CashPayment(amountDue, paymentAmount); 
			while(cp.getAmountDue()>0){
				System.out.println("Remaining balance: $"+ df.format(cp.getAmountDue())); 
				System.out.println("Please insert cash. Enter amount in USD: ");
				paymentAmount = input.nextInt();
				cp.makePostCashPayment(paymentAmount);
				}
			System.out.println("Change: $" + df.format(cp.getChange())); 
			Receipt receipt = new Receipt(cp);
			receipt.printReceipt();
			pause();
			if(isFlatRate==true)garage.exitGarage(); 
			if(isFlatRate==false)garage.exitGarage(ticket); 
			break;	
		case 2: 
			System.out.println("Please enter account number (16 digits no dashes): ");
			String accountNum = input.next();
			System.out.println("Please enter expiration date (format MM/yyyy): ");
			String expDate = input.next();
			ElectronicPayment ep = new ElectronicPayment(amountDue, accountNum, expDate);
			if(ep.isAccountValid()){
				Receipt r = new Receipt(ep);
				r.printReceipt();
				pause();
				if(isFlatRate==true)garage.exitGarage(); 
				else garage.exitGarage(ticket); 
			}
			else paymentMenu(amountDue, ticket, isFlatRate);
			break;
		case 3: break;
		default:
			System.out.println("Invalid selection.\n");
			paymentMenu(amountDue, ticket, isFlatRate); break;
		}
	}
	
	public void empMenu(){
		int empChoice=0;	
		String userName = null;
		System.out.println("Please Select an option: \n1. Update Hourly Rate "
				+ "\n2. Update Flat Rate \n3. Update Spaces \n4. Create New User "
				+ "\n5. Deactivate User \n6. Back");
		empChoice = input.nextInt();
		switch(empChoice){
		case 1: 
			System.out.println("Enter new hourly rate: ");
			int newHourlyRate = input.nextInt();
			garage.updateGarageStandardRate(newHourlyRate);break;
		case 2: 
			System.out.println("Enter new flat rate: ");
			int newFlatRate = input.nextInt();
			garage.updateGarageFlatRate(newFlatRate);break;
		case 3: 
			System.out.println("Enter new number of total spaces: ");
			int newNumSpaces = input.nextInt();
			garage.updateGarageSpaces(newNumSpaces);break;
		case 4: 
			System.out.println("Enter new user name: ");
			userName = input.next();
			System.out.println("Enter new user pass code using numeric value: ");
			String pwChoice = input.next();
			garage.createEmployee(userName, pwChoice); break;
		case 5: 
			System.out.println("Enter user name to deactivate: ");
			userName = input.next();
			Employee emp = garage.getEmployeeFromList(userName);
			emp.deactivateUser(); break;
		case 6: break;	
		default:
			System.out.println("Invalid selection.\n");
			empMenu(); break;
		}
	}
	
	public int getTicketID(){
		System.out.println("Enter ticket ID: ");
		ticketID = input.nextInt();
		return ticketID;
	}
	
	public static void main(String [ ] args){
		Garage garage = new Garage();
		Scanner input = new Scanner(System.in);
		Controller garageController = new Controller();
		garageController.mainMenu();
	}
}
