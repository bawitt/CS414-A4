package a4.application;

public class Spaces {
	int numSpaces;
	int usedSpaces;
	boolean vacancy;
	
	public Spaces(int s, int u){
		numSpaces = s;
		usedSpaces = u;
		updateVacancy();
	}
	
	public void updateVacancy(){
		if(usedSpaces<numSpaces){
			vacancy = true;
		}
		else vacancy = false;
	}
	public void incEnter(){
		usedSpaces = usedSpaces + 1;
	}
	public void decExit(){
		usedSpaces = usedSpaces - 1;
	}
	
	public void setVacancy(boolean s){
		vacancy = s;
	}
	public boolean getVacancy(){
		return vacancy;
	}
	
	public void setNumSpaces(int s){
		numSpaces = s;
	}
	public int getNumSpaces(){
		return numSpaces;
	}
	public void setUsedSpaces(int s){
		usedSpaces = s;
	}
	public int getUsedSpaces(){
		return usedSpaces;
	}
	
	
}
