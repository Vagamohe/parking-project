package models.levels;

import models.spots.Spots;

public abstract class Levels extends Spots {
	protected String location;
	public Levels(String Spotid,String location) {
		super(Spotid);
		this.location=location;
	}
}