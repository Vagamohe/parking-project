package models.spots;

import java.io.Serializable;

import models.vehicls.Vehicle;
	public class LargeSpot extends Spots implements Serializable{
		public LargeSpot(String Spotid) {
			super (Spotid);
		}
		@Override
		public  void occupy(Vehicle vehicle) {
			available=false;
		}
		public void release() {
			available=true;
		}
	}
