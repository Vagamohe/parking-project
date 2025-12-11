package models.tickets;
import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import models.vehicls.Vehicle;
public class HourlyTicket extends Tickets implements Serializable {
	private final double HourRate=50;
	private int hourlyTicketId;
	Random ran=new Random();
	public HourlyTicket(Vehicle vehicle) {
		 super(vehicle);
		 this.hourlyTicketId=ran.nextInt(100)+1;
	}
	@Override
	public double calculateBill(){
		if ((ChronoUnit.HOURS.between(entryTime, exitTime)>=24)){
			return 200 * ChronoUnit.DAYS.between(entryTime.toLocalDate(), exitTime.toLocalDate()) ;
		}else {
		return HourRate*(ChronoUnit.HOURS.between(entryTime, exitTime));
	    }
	}
	public int getTicketId() {
		return this.hourlyTicketId;
	}
}
