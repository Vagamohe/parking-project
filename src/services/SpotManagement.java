package services;
import java.io.Serializable;
import java.util.ArrayList;
import models.vehicls.*;
import java.util.List;

import exceptions.SpotNotAvailableException;
import models.spots.Spots;
import models.tickets.Tickets;
public class SpotManagement{
	private List<Spots> spots;
	Spots spot1;
    public SpotManagement() {
        this.spots = new ArrayList<>();
    }
    public void addSpot(Spots spot) {
    	spots.add(spot);
    }
    public <T extends Spots> T findAvailableSpotByType(Class<T> type) {
        for (Spots spot : spots) {
        	    if (type.isInstance(spot) && !spot.isOccupied()) {
        		     return (T) spot;
             }
        }
        return null;
      }
    public double getOccupancyRate() {
        if (spots.isEmpty())
        	return 0;
        long occupied = 0;
		for (Spots s : spots) {
            if (s.isOccupied()==true) {
                occupied++;
            }
        }
        return (double) occupied / spots.size() * 100;
    }
    public void ReserveSpotbytype(Vehicle vehicle,Spots spot) throws SpotNotAvailableException {
    	if (spot != null && spot.isOccupied()==false) {
    		//available==false
            spot.occupy(vehicle);
            vehicle.setSpot(spot);
            spot.setOccupied(true);
        } else {
            throw new SpotNotAvailableException("SpotNotAvailableException");
        }
    }
	public List<Spots> getSpots() {
        return spots;
    }
}