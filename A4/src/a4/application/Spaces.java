package a4.application;

public class Spaces {
	int numSpaces;
	int usedSpaces;
	
	public Spaces(int s, int u){
		numSpaces = s;
		usedSpaces = u;
	}
	public Spaces(){
		numSpaces = 0;
		usedSpaces = 0;
	}
	
	public void incEnter(){
		usedSpaces = usedSpaces + 1;
	}
	public void decExit(){
		usedSpaces = usedSpaces - 1;
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
