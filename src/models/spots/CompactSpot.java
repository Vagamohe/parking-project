package models.spots;

import java.io.Serializable;

import models.vehicls.Vehicle;

public class CompactSpot extends Spots implements Serializable{
	public CompactSpot(String Spotid) {
		super (Spotid);
	}
	@Override
	public  void occupy(Vehicle vehicle) {
		available=false;
	}
	public void release() {
		available=true;
	}
}
