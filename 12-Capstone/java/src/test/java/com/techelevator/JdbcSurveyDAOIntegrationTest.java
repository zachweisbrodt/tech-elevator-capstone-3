package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.model.JdbcSurveyDAO;

public class JdbcSurveyDAOIntegrationTest extends DAOIntegrationTest {
	
private JdbcSurveyDAO dao;

	
	@Before
	public void setup() {
		dao = new JdbcSurveyDAO(getDataSource());
	}

	@Test
	public void getFavoriteParksTest() {
		Survey testSurvey = new Survey();
		testSurvey.setActivityLevel("ddd");
		testSurvey.setEmailAddress("jaj");
		testSurvey.setState("Ohio");
		testSurvey.setParkCode("GNP");
		Survey testSurvey1 = new Survey();
		testSurvey1.setActivityLevel("ddd");
		testSurvey1.setEmailAddress("jaj");
		testSurvey1.setState("Ohio");
		testSurvey1.setParkCode("GNP");
		dao.addSurvey(testSurvey);
		dao.addSurvey(testSurvey1);
		assertEquals("Glacier National Park", dao.getFavoriteParks().get(0).getParkName());
		assertEquals(2, dao.getFavoriteParks().get(0).getNumberOfFavorites());
	}
}
