package com.techelevator.npgeek;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.npgeek.model.JdbcWeatherDAO;

public class JdbcWeatherDAOIntegrationTest extends DAOIntegrationTest {
private JdbcWeatherDAO dao;

	
	@Before
	public void setup() {
		dao = new JdbcWeatherDAO(getDataSource());
	}
	
	@Test
	public void getWeatherByParkCodeTest() {
		
	assertEquals("snow", dao.getWeatherByParkCode("GNP").get(0).getForecast());
	
	assertEquals(34, dao.getWeatherByParkCode("GCNP").get(1).getLow());
	
	assertEquals(51, dao.getWeatherByParkCode("YNP2").get(0).getHigh());
	}
	
}
