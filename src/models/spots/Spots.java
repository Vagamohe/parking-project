package models.spots;

import java.io.Serializable;

import models.vehicls.Vehicle;

public abstract class Spots implements Serializable {
	private String Spotid;
	protected boolean available=true,isoccupied=false;
	//when we create a new Spot the spot is free
	public Spots(String Spotid) {
		this.Spotid=Spotid;
		this.available = true;
	}
	public String getSpotID() {
		return Spotid;
	}
	public boolean isOccupied() {
	    return isoccupied;
	}
	public void setOccupied(boolean occupied) {
	    this.isoccupied = occupied;
	}

	//the spot is occupied مشغولة
	public abstract void occupy(Vehicle vehicle);
	//the spot is release or free
	public abstract void release();
}