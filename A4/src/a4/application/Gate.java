package a4.application;

public class Gate {
	GateType type;
	boolean open;
	
	public Gate(GateType t){
		type = t;
		open = false;
	}
	
	void closeGate(){
		open = false;
		System.out.println(type + " gate closed. Thank you.");
	}
	void openGate(){
		open = true;
		System.out.println(type + " gate open. Please enter.");
	}	
	public GateType getType(){
		return type;
	}

}
