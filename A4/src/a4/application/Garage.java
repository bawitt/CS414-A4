package a4.application;

public class Garage {
	private Sign capacitySign;
	private Gate entryGate;
	private Gate exitGate;
	private Rate garageRate;
	private Spaces garageSpaces;
	
	public Garage(){
		capacitySign = new Sign();
		entryGate = new Gate(GateType.entrance);
		exitGate = new Gate(GateType.exit);
		garageRate = new Rate(4, 50);  //update hard value
		garageSpaces = new Spaces(100,0);  //update hard value
	}
	
	public void updateSignStatus(){
		capacitySign.refreshSign(garageSpaces);
	}
	public void updateGarageSpaces(){
		garageSpaces.setNumSpaces(100);  //update hard value
	}
	public void updateGarageRate(double r, double fr){
		garageRate.setStandardRate(r);
		garageRate.setFlatRate(fr);
	}
	
	
}
