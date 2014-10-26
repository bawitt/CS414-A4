package a4.application;

import java.util.Scanner;
//import javax.swing.*;

public class Controller {
	Garage garage = new Garage();
	Scanner input = new Scanner(System.in);
	int choice;
	int ticketID;
	Payment pay;
	double payAmount;
	String userName;
	
	public void pause(){
		System.out.println("Press Enter to continue");
		try{System.in.read();}
		catch(Exception e){}
	}
	
	public void mainMenu(){
		int mainChoice=0;	
		while (mainChoice !=5){
		System.out.println("Please Select an option: \n1. Enter Garage "
				+ "\n2. Exit Garage \n3. Request Assistance \n4. Employee Login \n5. Quit");
		mainChoice = input.nextInt();
		switch(mainChoice){
		case 1: garage.issueTicket(); break;
		case 2: exitMenu(); break;
		case 3: System.out.println("Assistance requested"); break;
		case 4: 			
			System.out.println("Enter user name: ");
			userName = input.next(); 
			System.out.println("Enter user pass code: ");
			int pwChoice = input.nextInt();
			boolean loginSuccess = garage.authorizeUser(userName, pwChoice);
			if(loginSuccess) {System.out.println("Successful login."); empMenu();}
			else {System.out.println("Login unsuccessful."); mainMenu();}
			break;
		case 5: System.out.println("Exiting..."); break;
		}
		pause();
		}
	}
	public void exitMenu(){
		int exitChoice = 0;
		System.out.println("Please Select an option: \n1. Enter Ticket ID "
				+ "\n2. Flat Rate Payment \n3. Back");
		exitChoice = input.nextInt();
		switch(exitChoice){
		case 1: 
			ticketID = getTicketID();
			Ticket ticket = garage.getTicketFromList(ticketID);
			pay= new Payment(ticket); 
			System.out.println("Amount due: " + pay.getAmountDue()); 
			paymentMenu(pay); break;
		case 2: 
			pay= new Payment(garage.getGarageRate()); 
			System.out.println("Amount due: $" + pay.getAmountDue());
			paymentMenu(pay); break;
		case 3: mainMenu(); break;
		}
		//pause();
	}
	
	public void paymentMenu(Payment pay){
		int payChoice = 0;
		System.out.println("Please Select an option: \n1. Cash Payment "
				+ "\n2. Electronic Payment \n3. Back");
		payChoice = input.nextInt();
		switch(payChoice){
		case 1: 
			System.out.println("Please insert cash. Enter amount in USD: ");
			double paymentAmount = input.nextInt();
			CashPayment cp = new CashPayment(pay, paymentAmount); 
			while(cp.getAmountDue()>0){
				System.out.println("Remaining balance: "+ cp.getAmountDue()); 
				System.out.println("Please insert cash. Enter amount in USD: ");
				paymentAmount = input.nextInt();
				cp.makePostCashPayment(paymentAmount);
				}
			System.out.println("Change: $" + cp.getChange()); 
			Receipt receipt = new Receipt(pay);
			receipt.printReceipt();
			pause();
			if(pay.getIsFlatRate()==true)garage.exitGarage(); 
			if(pay.getIsFlatRate()==false)garage.exitGarage(pay.getPaymentTicket()); 
			break;
			
		case 2: 
			System.out.println("Please enter account number");
			int accountNum = input.nextInt();
			ElectronicPayment ep = new ElectronicPayment(pay, accountNum); 
			Receipt r = new Receipt(pay);
			r.printReceipt();
			pause();
			if(pay.getIsFlatRate()==true)garage.exitGarage(); 
			if(pay.getIsFlatRate()==false)garage.exitGarage(pay.getPaymentTicket()); 
			break;
		case 3: mainMenu(); break;
		}
		//pause();
	}
	
	public void empMenu(){
		int empChoice=0;	
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
			int pwChoice = input.nextInt();
			garage.createEmployee(userName, pwChoice); break;
		case 5: 
			System.out.println("Enter user name to deactivate: ");
			userName = input.next();
			Employee emp = garage.getEmployeeFromList(userName);
			emp.deactivateUser(); break;
		case 6: mainMenu(); break;	
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
