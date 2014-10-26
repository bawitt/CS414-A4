package a4.application;

public class Employee {
	String username;
	int passNum;
	boolean isAdmin;
	boolean isActive;
	
	public Employee(String un, int pn){
		username = un;
		passNum = pn;
		isActive = true;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public boolean isApproved(int pn){
		if(isActive && (passNum==pn)){
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
	
}
