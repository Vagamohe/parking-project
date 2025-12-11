package models.vehicls;
import java.io.Serializable;

import interfaces.Parkable;
import models.spots.Spots;
public abstract class Vehicle implements Parkable, Serializable {
	private int licensPlate;
	private String brand;
	Spots spot;
	public Vehicle(int licensPlate,String brand) {
		this.licensPlate=licensPlate;
		this.brand=brand;
	}
	public int getLicensPlate() {
		return licensPlate;
	}
	public  String getBrand() {
		return brand;
	}
    public Spots getSpot() {
        return spot;
    }
    public void setSpot(Spots spot) {
        this.spot = spot;
    } 
	@Override 
	public void park() {
		System.out.println("vehicel parked: "+licensPlate);
	}
	@Override 
	public void leave() {
		System.out.println("vehicel leave: "+licensPlate);
	}
	@Override
	public String toString() {
	    return getClass().getSimpleName() + " { plate=" + getLicensPlate() + "/" + ", brand=" + getBrand() + " }";
	}

}
