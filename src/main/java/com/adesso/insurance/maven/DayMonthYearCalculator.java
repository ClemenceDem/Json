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
	
	 
	 static ResourceBundle messages = ResourceBundle.getBundle("src/main/resources/config/messages_de.properties");
	
    public static void setLocale(Locale locale) {
        messages = ResourceBundle.getBundle("messages", locale);
    }
	
	public static LocalDate getDayMonthYear(String date) {

		if (date.contains(".") || date.contains("/")) {
			date = date.replaceAll("[./]", "-");
		}

		LocalDate birthDate = LocalDate.parse(date);

		return birthDate;
	}

	public static void getTag(LocalDate birthDate) {

		int day = birthDate.getDayOfMonth();
		String message = messages.getString("tag.message");
		LOGGER.info("Tag : " +  message ,day);
	}

	public static void getMonth(LocalDate birthDate) {

		Month month = birthDate.getMonth();
		String message = messages.getString("month.message");
		LOGGER.info("Month : " + message, month);
	}

	public static void getYear(LocalDate birthDate) {

		int year = birthDate.getYear();
		String message = messages.getString("year.message");
		LOGGER.info("Year : " + message,  year);
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

			String dateFormatted = date.format(outputFormatter);
            String message = messages.getString("new.date.format");
			LOGGER.info("New Format of the Date : " + message,  dateFormated);
		} catch (DateTimeParseException e) {
			String message = messages.getString("date.format.error");
			LOGGER.error("Invalid date format: " + message,dateStr);
			
				   
		
	}
		
	}
}


