package com.speakingclock.controller;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.service.ClockService;

@RestController
@RequestMapping("/api/clock")
public class RestClockController {

	
	public ClockService clockService;
	public RestClockController(ClockService clockService) {
		super();
		this.clockService = clockService;
	}


	//localhost:8080/api/clock/currentTime
	@GetMapping("/currentTime")
	public ResponseEntity<String> getCurrentTimeInWords() throws IllegalArgumentException{
		LocalTime localTime = LocalTime.now();		//Getting system's current time
		int hour = localTime.getHour();
		int minutes = localTime.getMinute();
		
		String timeInWords = clockService.convertTimeToWords(hour, minutes); 
		
		return new ResponseEntity<String>(timeInWords, HttpStatus.OK);
	}
	
	//localhost:8080/api/clock/convert/16:05
	@GetMapping("/convert/{time}")
	public ResponseEntity<String> convertCustomTimeInWords(@PathVariable("time") String timeString) throws IllegalArgumentException{
		String[] splitedTime = timeString.split(":");
		
		if(splitedTime.length != 2) {
			//throw new IllegalArgumentException("Invalid Time formate.");
			return ResponseEntity.badRequest().body("Invalid Time formate.");
		}
		
		
		int hour = Integer.parseInt(splitedTime[0]);
		if(hour <0 || hour >23)		// Checks hour is valid or not
			throw new IllegalArgumentException("Invalid Hour.");
		
		int minutes = Integer.parseInt(splitedTime[1]);
		if(minutes < 0 || minutes > 59 ) 	// Checks minutes is valid or note
			throw new IllegalArgumentException("Invalide Minute.");
		
		
		String timeInWords = clockService.convertTimeToWords(hour, minutes); 
		
		return ResponseEntity.ok(timeInWords);
	}
}


