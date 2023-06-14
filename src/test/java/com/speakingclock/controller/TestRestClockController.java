package com.speakingclock.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.speakingclock.service.ClockService;

public class TestRestClockController {

		public RestClockController restClockController;
		public ClockService clockService;
		public TestRestClockController(RestClockController restClockController, ClockService clockService) {
			super();
			this.restClockController = restClockController;
			this.clockService = clockService;
		}

		@Test
	    public void testConvertToWords_Success() {
			System.out.println("Test 1");
	        String timeString = "08:34";
	        String expectedResponse = "It's eight thirty-four AM";
	        
	        ResponseEntity<String> convertedCustomTimeInWords = restClockController.convertCustomTimeInWords(timeString);

	        assertEquals(HttpStatus.OK, convertedCustomTimeInWords.getStatusCode());
	        assertEquals(expectedResponse, convertedCustomTimeInWords.getBody());
	    }

		@Test
	    public void testConvertToWords_InvalidFormat() {
			System.out.println("Test 2");
	        String timeString = "08:34:59";

	        ResponseEntity<String> response = restClockController.convertCustomTimeInWords(timeString);

	        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	        assertEquals("Invalid Time formate.", response.getBody());
	    }

}