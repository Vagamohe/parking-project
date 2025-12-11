package models.tickets;
import java.io.Serializable;
import java.time.LocalDateTime;
import interfaces.billable;
import models.vehicls.Vehicle;
public abstract class Tickets implements billable,Serializable {
    protected Vehicle vehicle;
    protected LocalDateTime entryTime;
    protected LocalDateTime exitTime;
	public Tickets(Vehicle vehicle) {
		this.vehicle=vehicle;
		this.entryTime=LocalDateTime.now();
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	 public void setExitTime() { 
		 this.exitTime = LocalDateTime.now();
	 }
	 abstract public int getTicketId() ;
}