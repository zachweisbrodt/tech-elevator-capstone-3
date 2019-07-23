package com.techelevator.npgeek.model;

import java.util.ArrayList;

import com.techelevator.npgeek.Weather;

public interface WeatherDAO {

	public ArrayList<Weather> getWeatherByParkCode(String parkCode);
	
	public String getCamelCase(String forecast);
	
	public String getForecastAdvice(String forecast);
	
	public String getTemperatureAdvice(int high, int low);
	
}
