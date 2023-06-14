package com.speakingclock.service.impl;

import org.springframework.stereotype.Service;

import com.speakingclock.service.ClockService;

@Service
public class ClockServiceImpl implements ClockService{

	@Override
	public String convertTimeToWords(int hour, int minutes) {

		String[] hourInWords = new String[] {
				"twelve", "one", "two", "three", "four", 
				"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"
		};
		
		String[] minutesInWords = {
	            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
	            "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
	            "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight",
	            "twenty-nine", "thirty", "thirty-one", "thirty-two", "thirty-three", "thirty-four",
	            "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
	            "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six",
	            "forty-seven", "forty-eight", "forty-nine", "fifty", "fifty-one", "fifty-two",
	            "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight",
	            "fifty-nine"
	        };
		
		String timeInWords = null;
		
		if (hour < 12) {
			timeInWords = "It's " +hourInWords[hour]+ " " +minutesInWords[minutes]+ " AM";
			if(hour == 0)
				timeInWords += " And It's Midnight.";
		}else {
			int hour1 = hour % 12;
			timeInWords = "It's " +hourInWords[hour1]+ " " +minutesInWords[minutes]+ " PM";
			if(hourInWords[hour1].equals("twelve"))
				timeInWords += " And It's Midday.";
		}
		
		return timeInWords;
	}

	
	
}
