package services;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import exceptions.SpotNotAvailableException;
import models.*;
import models.spots.RegularSpot;
import models.spots.Spots;
import models.tickets.Tickets;
import models.vehicls.Vehicle;
import services.SpotManagement;
import models.tickets.*;
public class EntryRegistration implements Serializable{
	private List<Vehicle> entryvehicle;
	private List <Tickets> activeTickets=TicketsStorage.loadTickets();
	private SpotManagement spotManagement;
	Tickets t;
    public EntryRegistration(SpotManagement spotManagement) {
        this.spotManagement = spotManagement;
        this.entryvehicle = new ArrayList<>();
    }
	public <T extends Spots> Tickets registerEntry(Vehicle vehicle,Class<T> spottype,String tickettype) throws SpotNotAvailableException, IOException{
		 if (isVehicleRegistered(vehicle.getLicensPlate())) {
		      System.out.println("This vehicle is already registered.");
		      return null; 
		 }
		 T spot = spotManagement.findAvailableSpotByType(spottype);
		 if (spot==null) {
			 throw new SpotNotAvailableException("sorry there is not available spot");
		 }else {
			 spotManagement.ReserveSpotbytype(vehicle, spot);
			 switch (tickettype.toUpperCase()) {
			 case "HOURLY" : t = new HourlyTicket(vehicle);
			 break;
			 case "DAILY" : t = new DailyTicket(vehicle);
			 break;
			 case "MONTHLY" : t = new MonthlyTicket(vehicle);
			 break;
			 default : t=null;
			 break;
			 }
			 activeTickets.add(t);		    
		     entryvehicle.add(vehicle);
		     savesVehicles.saveData(entryvehicle);
			 TicketsStorage.saveTickets(activeTickets);
			 savespots.saveData(spotManagement);
		 return t;
		}
	}
	public boolean isVehicleRegistered(int licensePlate) {
	    try (BufferedReader br = new BufferedReader(new FileReader("Vehicle.txt"))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(";");
	            int savedPlate = Integer.parseInt(data[1]);
	            if (savedPlate == licensePlate) {
	                return true; // السيارة موجودة مسبقًا
	            }
	        }
	    } catch (Exception e) {
	        // الملف غير موجود أو فارغ — يعني لا يوجد سيارة مسجلة
	    }
	    return false;
	}
	public List<Tickets> getActiveTickets() {
	        return activeTickets;
	}
	public List<Vehicle> getEntryvehicle() {
        return entryvehicle;
}
}
