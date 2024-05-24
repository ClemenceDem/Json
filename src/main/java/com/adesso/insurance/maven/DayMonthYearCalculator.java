package com.adesso.insurance.maven;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DayMonthYearCalculator {
	
	private static final Logger logger = LoggerFactory.getLogger(DayMonthYearCalculator.class);
	 
	// Function to get day, month, and year from date
    public static void getDayMonthYear(String date) {
    	String format = null;
    	
    	if (date.contains(".") || date.contains("/")) { 
    	    format = date.replaceAll("[./]", "-");
    	} 
    	
        // Get an instance of LocalTime from date
        LocalDate birthDate = LocalDate.parse(format);
 
        // Get day from date
        int day = birthDate.getDayOfMonth();
 
        // Get month from date
        Month month = birthDate.getMonth();
 
        // Get year from date
        int year = birthDate.getYear();
 
        // Print the day, month, and year
       logger.info("Day: " + day);
       logger.info("Month: " + month);
       logger.info("Year: " + year);
    }
 
   public static void setDateFormat(String date){
	   
	   final String OLD_FORMAT = "dd/MM/yyyy";
	   final String NEW_FORMAT = "yyyy/MM/dd";
	   

   }
}


