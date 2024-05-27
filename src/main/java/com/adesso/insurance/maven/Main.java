package com.adesso.insurance.maven;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws ParseException, IOException {

		OptionValiedierung option = new OptionValiedierung();

		Person pers = new Person("Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124);

		LOGGER.info(ConvertJavaObjektToJson.jsonValue(pers));

		option.OptionValiedierungsArgument(args);

		ConvertJsonToJvaObject.javaObjectValue(option.getPathFile());

		String date = "1995/02/01";

		LocalDate dateFormated = DayMonthYearCalculator.DayMonthYearValue(date);

		DayMonthYearCalculator.tagValue(dateFormated);
		DayMonthYearCalculator.monthValue(dateFormated);
		DayMonthYearCalculator.yearValue(dateFormated);

		DayMonthYearCalculator.convertDateFormat(date.toString());

	}

}
