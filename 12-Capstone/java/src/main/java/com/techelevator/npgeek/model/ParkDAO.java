package com.techelevator.npgeek.model;

import java.util.List;

import com.techelevator.npgeek.Park;

public interface ParkDAO {

	public List<Park> getAllParks();
	
	public Park getParkByParkCode(String parkCode);
	
	public String getParkImageName(String parkCode);
	
}
