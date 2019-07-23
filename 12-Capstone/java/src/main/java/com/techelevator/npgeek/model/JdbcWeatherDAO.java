package com.techelevator.npgeek.model;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Weather;

@Component
public class JdbcWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ArrayList<Weather> getWeatherByParkCode(String parkCode) {
		
		ArrayList<Weather> allWeather = new ArrayList<>();
		String sqlSelectWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkCode, parkCode);
		while (results.next()) {
			allWeather.add(mapRowToWeather(results));
		}
		return allWeather;
	}

	@Override
	public String getCamelCase(String forecast) {

		String camelCase = forecast;
		
		if (forecast.equals("partly cloudy")) {
			camelCase = "partlyCloudy";
			return camelCase;
		}
		else {
		return camelCase;
		}
	}
	
	@Override
	public String getForecastAdvice(String forecast) {
		
		if (forecast.equals("snow")) {
			return "Pack snowshoes.";
		}
		if (forecast.equals("rain")) {
			return "Pack rain gear and wear waterproof shoes.";
		}
		if (forecast.equals("thunderstorms")) {
			return "Seek shelter and avoid hiking on exposed ridges.";
		}
		if (forecast.equals("sun")) {
			return "Pack sunblock.";
		}
		else return "";
	}
	
	@Override 
	public String getTemperatureAdvice(int high, int low) {
		if ((high - low > 20) && (high > 75)) {
			return "Bring an extra gallon of water and wear breathable layers.";
		}
		if ((high - low > 20) && (low < 20)) {
			return "WARNING: It is dangerous to be exposed to frigid temperatures and wear breathable layers.";
		}
		if (high - low > 20) {
			return "Wear breathable layers.";
		}
		if (high > 75) {
			return "Bring an extra gallon of water.";
		}
		if (low < 20) {
			return "WARNING: It is dangerous to be exposed to frigid temperatures.";
		}
		else return "";
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		weather.setLow(results.getInt("low"));
		weather.setHigh(results.getInt("high"));
		weather.setForecast(getCamelCase(results.getString("forecast")));
		weather.setForecastAdvice(getForecastAdvice(results.getString("forecast")));
		weather.setTemperatureAdvice(getTemperatureAdvice(results.getInt("high"), results.getInt("low")));
		weather.setLowInCelsius(results.getInt("low"));
		weather.setHighInCelsius(results.getInt("high"));
		return weather;
	}
	
}
