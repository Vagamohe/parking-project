package services;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import models.spots.Spots;
public class savespots {
	public static void saveData(SpotManagement sp) {
	    try (PrintWriter out = new PrintWriter(new FileOutputStream("spots.txt"))) {
	        for (Spots s : sp.getSpots()) {
	            out.println(s.getClass().getSimpleName() + ";" +
	                        s.getSpotID() + ";" +
	                        s.isOccupied());
	        }
	    } catch (Exception e) {
	        System.out.println("Error saving: " + e.getMessage());
	    }
	}
}
