package com.adesso.insurance.maven;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DayMonthYearCalculator {

	private static final Logger logger = LoggerFactory.getLogger(DayMonthYearCalculator.class);
	final static String OLD_FORMAT = "yyyy/MM/dd";
	final static String NEW_FORMAT = "dd/MM/yyyy";

	// Function to get day, month, and year from date
	public static LocalDate getDayMonthYear(String date) {
		
		if (date.contains(".") || date.contains("/")) {
			date = date.replaceAll("[./]", "-");
		}
         // create an LocalDate object
		LocalDate birthDate = LocalDate.parse(date);
		
		return birthDate;
	}

	public static void getDay(LocalDate birthDate) {
		
		// Get day from date
		int day = birthDate.getDayOfMonth();
		logger.info("day : " + day);
	}

	public static void getMonth(LocalDate birthDate) {
		// Get Month from date
		Month month = birthDate.getMonth();
		logger.info("Month : " + month);
	}

	public static void getYear(LocalDate birthDate) {
		// Get year from date
		int year = birthDate.getYear();
		logger.info("Year : " + year);
	}

	public static void convertDateFormat(String dateStr) {
		
		if (dateStr.contains(".") || dateStr.contains("-")) {
			dateStr = dateStr.replaceAll("[.-]", "/");
		}

		try {
			// Define the formatter for the input format
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(OLD_FORMAT);
			// Parse the date string to a LocalDate object
			LocalDate date = LocalDate.parse(dateStr, inputFormatter);

			// Define the formatter for the output format
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(NEW_FORMAT);
			// Format the LocalDate object to the desired output format
            String dateFormated = date.format(outputFormatter);
			logger.info("New Format of the Date : " + dateFormated);
		} catch (DateTimeParseException e) {
			logger.error("Invalid date format: " + dateStr);
		}
	}

}
