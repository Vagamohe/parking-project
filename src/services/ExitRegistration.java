package services;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import exceptions.SpotNotAvailableException;
import exceptions.TicketNotFoundException;
import models.*;
import models.spots.RegularSpot;
import models.spots.Spots;
import models.tickets.Tickets;
import models.vehicls.Vehicle;
import services.SpotManagement;
import models.tickets.*;
public class ExitRegistration implements Serializable{
	private EntryRegistration er;
	private SpotManagement sp;
	List <Tickets> activeTickets;
	public List<Spots> spots;
	Tickets toRemove = null;
	Tickets ticket;
	public ExitRegistration (EntryRegistration er,SpotManagement sp) {
		this.er=er;
		this.sp=sp;
	}
	public double registerExit(int ticketid) throws TicketNotFoundException, IOException {
		if (ticketid==0)
			return 0;
		activeTickets=er.getActiveTickets();
		spots=sp.getSpots();
		for (Tickets p:activeTickets) {
			if  (p.getTicketId()==ticketid) {
		         p.setExitTime();
		         ticket =p;
		         break;
			}else {
				ticket=null;
			}
		}
		if (ticket==null) {
			throw new TicketNotFoundException("the ticket wasn't found");
		}
		double fee=ticket.calculateBill();
		for (Tickets r:activeTickets) {
			if  (r.equals(ticket)) {
				toRemove = r; 
	            break;
		    }
	    }
		if (toRemove != null) {
			er.getEntryvehicle().remove(ticket.getVehicle());
			savesVehicles.saveData(er.getEntryvehicle());
			activeTickets.remove(toRemove); 
			TicketsStorage.saveTickets(activeTickets);
		}
		Spots spot =ticket.getVehicle().getSpot();
		if (spot!=null) {
		spots.remove(spot);
		spot.release();
		spot.setOccupied(false);
	    }
		ticket.getVehicle().setSpot(null);
		savespots.saveData(sp);
		return fee;
        }
}