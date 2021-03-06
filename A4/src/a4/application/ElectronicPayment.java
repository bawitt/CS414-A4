package a4.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ElectronicPayment extends Payment{
	private String accountNum;
	private String expDate;
	//private double amountDue;
	
	public ElectronicPayment(double ad, String act, String ed){
		super(ad, PaymentType.electronic);
		accountNum = act;
		//amountDue = ad;	
		expDate = ed;
	}
	
	public boolean isAccountValid(){
		if(isDateValid()&&isActNumValid()){
			return true;
		}
		else return false;
	}
	
	public boolean isDateValid(){  //check date format
		String ed = expDate;
		SimpleDateFormat dtfmt = new SimpleDateFormat("MM/yyyy");
		Date date = null;
		try{
			date = dtfmt.parse(ed); 
		}
		catch (ParseException e)
        {
            System.out.println("Date format is invalid");
            return false;
        }
		return true;
	}
	public boolean isActNumValid(){
		String actNum= accountNum;
	    for(char c : actNum.toCharArray()) //check that actNum is all digits
	    {
	        if(!Character.isDigit(c)){
	        	System.out.println("\nAccount number format is invalid.\n");
	        	return false;
	        }
	    }
		if(actNum.length()!=16){  //check that actNum is correct length
			System.out.println("Account number length is invalid.");
			return false;
		}
		return true;
	}
}
