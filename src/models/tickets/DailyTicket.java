package models.tickets;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import models.vehicls.Vehicle;

public class DailyTicket extends Tickets implements Serializable {
	private final double DayRate=200;
	private int DailyTicketId;
	Random ran=new Random();
	public DailyTicket(Vehicle vehicle) {
		 super(vehicle);
		 this.DailyTicketId=ran.nextInt(100)+1;
	}
	@Override
	public double calculateBill() {
		if (ChronoUnit.DAYS.between(entryTime.toLocalDate(), exitTime.toLocalDate())>29) {
			return 4000* ChronoUnit.MONTHS.between(entryTime, exitTime);
		}else {
		return DayRate* ChronoUnit.DAYS.between(entryTime.toLocalDate(), exitTime.toLocalDate());
  	    }
	}
	public int getTicketId() {
		return this.DailyTicketId;
	}
}
