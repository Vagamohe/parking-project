package models.spots;

import java.io.Serializable;

import models.vehicls.Vehicle;

public class ElectricSpot extends Spots implements Serializable{
	public ElectricSpot(String Spotid) {
		super (Spotid);
	}
	@Override
	public void occupy(Vehicle vehicle) {
		available=false;
	}
	public void release() {
		available=true;
	}
}
