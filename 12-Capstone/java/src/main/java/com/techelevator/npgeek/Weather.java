package com.techelevator.npgeek;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private String forecastAdvice;
	private String temperatureAdvice;
	private int lowInCelsius;
	private int highInCelsius;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getForecastAdvice() {
		return forecastAdvice;
	}
	public void setForecastAdvice(String forecastAdvice) {
		this.forecastAdvice = forecastAdvice;
	}
	public String getTemperatureAdvice() {
		return temperatureAdvice;
	}
	public void setTemperatureAdvice(String temperatureAdvice) {
		this.temperatureAdvice = temperatureAdvice;
	}
	public int getLowInCelsius() {
		return lowInCelsius;
	}
	public void setLowInCelsius(int lowInCelsius) {
		this.lowInCelsius = (5 * (low - 32)) / 9;
	}
	public int getHighInCelsius() {
		return highInCelsius;
	}
	public void setHighInCelsius(int highInCelsius) {
		this.highInCelsius = (5 * (high - 32)) /9;
	}
	
	
	
	
	
}
