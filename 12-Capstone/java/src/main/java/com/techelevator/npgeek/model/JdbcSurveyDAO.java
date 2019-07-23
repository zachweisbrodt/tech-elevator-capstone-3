package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;

@Component
public class JdbcSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//returns new surveyId when survey information is inserted into database so we don't need another method to get next Id
	@Override
	public void addSurvey(Survey newSurvey) {
			
		Integer surveyId = jdbcTemplate.queryForObject("INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) VALUES(?, ?, ?, ?) RETURNING surveyid", Integer.class, 
				newSurvey.getParkCode(), newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());
		newSurvey.setSurveyId(surveyId);
	}

	@Override
	public List<Park> getFavoriteParks() {
		
		List<Park> favoriteParks = new ArrayList<Park>();
		String sqlSelectFavoriteParks = "SELECT park.parkname, survey_result.parkcode, COUNT(survey_result.parkcode) AS count FROM park JOIN survey_result ON survey_result.parkcode = park.parkcode GROUP BY park.parkname, survey_result.parkcode ORDER BY count DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFavoriteParks);
		while (results.next()) {
			favoriteParks.add(mapRowToPark(results));
		}
		return favoriteParks;
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setNumberOfFavorites(results.getInt("count"));
		return park;
	}

}
