package com.adesso.insurance.maven;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DayMonthYearCalculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(DayMonthYearCalculator.class);
	final static String OLD_FORMAT = "yyyy/MM/dd";
	final static String NEW_FORMAT = "dd/MM/yyyy";
	
	 
	 static ResourceBundle messages = ResourceBundle.getBundle("properties.language", Locale.GERMANY);
	 
	
    
	
	public static LocalDate DayMonthYearValue(String date) {

		if (date.contains(".") || date.contains("/")) {
			date = date.replaceAll("[./]", "-");
		}

		LocalDate birthDate = LocalDate.parse(date);

		return birthDate;
	}

	public static void tagValue(LocalDate birthDate) {

		int day = birthDate.getDayOfMonth();
		String message = messages.getString("jour");
		LOGGER.info(message+ " : "+day);
	}

	public static void monthValue(LocalDate birthDate) {

		Month month = birthDate.getMonth();
		String message = messages.getString("mois");
		LOGGER.info(message+ " : " +month);
	}

	public static void yearValue(LocalDate birthDate) {

		int year = birthDate.getYear();
		String message = messages.getString("année");
		LOGGER.info(message+ " : " +year);
	}

	public static void convertDateFormat(String dateStr) {

		if (dateStr.contains(".") || dateStr.contains("-")) {
			dateStr = dateStr.replaceAll("[.-]", "/");
		}

		try {

			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(OLD_FORMAT);
			LocalDate date = LocalDate.parse(dateStr, inputFormatter);

			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(NEW_FORMAT);
			String dateFormated = date.format(outputFormatter);

            String message = messages.getString("nouveau");
			LOGGER.info(message+ " : " +dateFormated);
		} catch (DateTimeParseException e) {
			String message = messages.getString("ancien");
			LOGGER.error(message+ " : " +dateStr);
			
				   
		
	}
		
	}
}


