package models.spots;
import java.io.Serializable;

import models.vehicls.*;
public class RegularSpot extends Spots implements Serializable{
	private Vehicle currentVehicle;
	public RegularSpot(String Spotid) {
		super (Spotid);
	}
	@Override
	public  void occupy(Vehicle vehicle) {
		available=false;
		this.currentVehicle=vehicle;
	}
	public void release() {
		available=true;
		this.currentVehicle = null;
	}
}
