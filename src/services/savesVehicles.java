package services;
import java.io.PrintWriter;
import java.util.List;
import java.io.FileOutputStream;
import models.spots.Spots;
import models.vehicls.Vehicle;
public class savesVehicles {
		public static void saveData(List<Vehicle>vehicle) {
		    try (PrintWriter out = new PrintWriter(new FileOutputStream("Vehicle.txt"))) {
		        for (Vehicle s : vehicle) {
		            out.println(s.getClass().getSimpleName() + ";" +
		                        s.getLicensPlate() + ";" +
		                        s.getLicensPlate());
		        }
		    } catch (Exception e) {
		        System.out.println("Error saving: " + e.getMessage());
		    }
		}
	}
