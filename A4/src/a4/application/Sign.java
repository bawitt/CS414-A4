package a4.application;

public class Sign {
	SignStatus status;
	
	public Sign(){
		status = SignStatus.vacancy;
	}
	public void refreshSign(Spaces s){
		if(s.usedSpaces<s.numSpaces){
			status = SignStatus.vacancy;
		}
		else status = SignStatus.full;
	}
	
	public SignStatus getSignStatus(){
		return status;
	}
	
	public void setSignStatus(SignStatus s){
		status = s;
	}
}
