package a4.application;

public class Employee {
	String username;
	String passNum;
	boolean isAdmin;
	boolean isActive;
	
	public Employee(String un, String pn){
		username = un;
		passNum = pn;
		isActive = true;
	}
	
	public Employee() {
		username = null;
	}
	public boolean isApproved(String pn){
		if(isActive && (passNum.equals(pn))){
			return true;
		}
		else return false;
	}
	public void deactivateUser(){
		isActive = false;
	}
	public String getUsername(){
		return username;
	}
	public boolean getIsActive(){
		return isActive;
	}
	
}
