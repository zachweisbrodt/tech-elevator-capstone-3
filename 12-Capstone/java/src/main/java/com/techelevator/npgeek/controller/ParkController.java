package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
@SessionAttributes("temperature")
public class ParkController {

	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	@Autowired
	private SurveyDAO surveyDAO;
	
	@RequestMapping(path = {"/", "/homePage" })
	public String displayHomePage(HttpServletRequest request, ModelMap map) {
		
		request.setAttribute("parkList", parkDAO.getAllParks());
		
		return "homePage";
	}
	
	//POST method to keep the temperature scale in a map for the session
	@RequestMapping(path = "/homePage", method = RequestMethod.POST)
	public String refreshHomePage(@RequestParam String temperature, ModelMap map) {
		map.addAttribute("temperature", temperature);
		return "redirect: homePage";
	}
	
	//Get all park details by parkCode passed in querystring based on what picture user clicks
	@RequestMapping(path = "/parkDetail")
	public String displayParkDetailPage(HttpServletRequest request) {
		String parkCode = request.getParameter("parkCode");
		Park park = parkDAO.getParkByParkCode(parkCode);
		
		//Create list of 5-day weather forecast from parkCode
		List<Weather> weatherList = weatherDAO.getWeatherByParkCode(parkCode);
		
		request.setAttribute("park",  park);
		request.setAttribute("weather", weatherList);
		
		return "parkDetail";
	}
	
	@RequestMapping(path = "/surveyForm", method = RequestMethod.GET)
	public String displaySurveyForm(ModelMap map) {

		map.put("parkList", parkDAO.getAllParks());
		
		if(!map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}
		
		return "surveyForm";
	}
	
	//Validates that all survey fields are properly filled in. If no errors, creates new Survey object and inserts into database
	@RequestMapping(path = "/surveyForm", method = RequestMethod.POST)
	public String addSurvey(@Valid @ModelAttribute("survey") Survey newSurvey, BindingResult result, ModelMap map) {
		if(result.hasErrors()) {
			map.put("parkList", parkDAO.getAllParks()); //If errors, repopulates map with park names to display on survey form
			return "surveyForm";
		}
		
		surveyDAO.addSurvey(newSurvey);
		return "redirect:/surveyResults";
	}
	
	//Creates favoriteParks map with parks with at least 1 vote
	@RequestMapping(path ="/surveyResults", method = RequestMethod.GET)
	public String getSurveyResults(ModelMap favoritesMap) {
		favoritesMap.put("favoriteParks", surveyDAO.getFavoriteParks());
		return "surveyResults";
	}
	
	

}
