package models.vehicls;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
	public Car(int licensPlate,String brand) {
		super(licensPlate,brand);
	}
	@Override
	public String toString() {
	    return "Car {plate=" + getLicensPlate() + "/" + ", brand=" + getBrand() + "/" +"}";
	}
}
