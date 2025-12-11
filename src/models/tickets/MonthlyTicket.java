package models.tickets;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import models.vehicls.Vehicle;

public class MonthlyTicket extends Tickets implements Serializable {
	private final double MonthRate=4000;
	private int MonthlyTicketId;
	Random ran=new Random();
	public MonthlyTicket(Vehicle vehicle) {
		 super(vehicle);
		 this.MonthlyTicketId=ran.nextInt(100)+1;
	}
	@Override
	public double calculateBill() {
		return MonthRate*(exitTime.getMonthValue()-entryTime.getMonthValue());
	}
	public int getTicketId() {
		return this.MonthlyTicketId;
	}
}
