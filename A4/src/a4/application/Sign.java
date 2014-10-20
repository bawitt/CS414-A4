package a4.application;

public class Sign {
	SignStatus status;
	
	public Sign(){
		status = SignStatus.vacancy;
	}
	
	public SignStatus getSignStatus(){
		return status;
	}
	
	public void setSignStatus(SignStatus s){
		status = s;
	}
}
