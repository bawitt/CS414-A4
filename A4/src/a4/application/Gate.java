package a4.application;

public class Gate {
	GateType type;
	boolean gateOpenStatus;
	
	public Gate(GateType t){
		type = t;
		gateOpenStatus = false;
	}
	
	void closeGate(){
		gateOpenStatus = false;
		System.out.println(type + " gate closed.");
	}
	void openGate(){
		gateOpenStatus = true;
		System.out.println(type + " gate open.");
	}	
	public GateType getType(){
		return type;
	}
	public boolean getGateOpenStatus(){
		return gateOpenStatus;
	}
	

}
