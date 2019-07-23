package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.JdbcParkDAO;

public class JdbcParkDAOIntegrationTest extends DAOIntegrationTest {
	
private JdbcParkDAO dao;
	
	@Before
	public void setup() {
		dao = new JdbcParkDAO(getDataSource());
	}
	
	@Test
	public void get_all_parks_test() {
	//Make a list of parks by calling the getAllParks method and ensuring we populate with the correct data from the park table
		List<Park> results = dao.getAllParks();
		Park testPark = results.get(0);
		Park testPark2 = results.get(1);
		Park testPark3 = results.get(2);
		
		assertEquals(10, results.size());
		
		assertEquals("CVNP", testPark.getParkCode());
		
		assertEquals("Florida", testPark2.getState());
		
		assertEquals(8000, testPark3.getElevationInFeet());
		
	}
	
	
	@Test
	public void getParkByParkCodeTest() {
		
		assertEquals("Ohio",dao.getParkByParkCode("CVNP").getState());
		
		assertEquals(800, dao.getParkByParkCode("YNP2").getMilesOfTrail(),.01);
	}
	
	@Test
	public void getParkImageNameTest() {
		assertEquals("cvnp.jpg", dao.getParkImageName("CVNP"));
		assertEquals("ynp2.jpg", dao.getParkImageName("YNP2"));
		
	}

}
