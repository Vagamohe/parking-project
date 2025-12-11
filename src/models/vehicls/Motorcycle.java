package models.vehicls;

import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable{
	public Motorcycle(int licensPlate,String brand) {
		super(licensPlate,brand);
	}
	@Override
	public String toString() {
	    return "Motorcycle {plate=" + getLicensPlate() + "/" + ", brand=" + getBrand() + "/" +"}";
	}
}
