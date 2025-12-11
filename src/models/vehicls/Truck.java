package models.vehicls;

public class Truck extends Vehicle {
	public Truck(int licensPlate,String brand) {
		super(licensPlate,brand);
	}
	@Override
	public String toString() {
	    return "Truck {plate=" + getLicensPlate() + "/" + ", brand=" + getBrand() + "/" +"}";
	}
}
