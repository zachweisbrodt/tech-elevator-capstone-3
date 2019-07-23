package com.techelevator.npgeek.model;

import java.util.List;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;

public interface SurveyDAO {

	public void addSurvey(Survey survey);
	
	public List<Park> getFavoriteParks();
	
}
