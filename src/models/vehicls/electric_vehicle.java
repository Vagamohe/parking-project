package models.vehicls;
import java.io.Serializable;

import interfaces.chargeable;
public class electric_vehicle extends Vehicle implements chargeable, Serializable {
	public electric_vehicle(int licensPlate,String brand) {
		super(licensPlate,brand);
	}
	@Override
	public void charge() {
		System.out.println("ُElectric vehicle is charging ...");	
	}
	@Override
	public String toString() {
	    return "Electric vehicle {plate=" + getLicensPlate() + "/" + ", brand=" + getBrand() + "/" +"}";
	}
}
