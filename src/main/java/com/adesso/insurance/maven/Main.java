package com.adesso.insurance.maven;

import java.io.IOException;
import java.time.LocalDate;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {

		OptionValiedierung option = new OptionValiedierung();

		String date = "1995/02/01";
		String liDate = "2022/10/29";
		String frDate = "1991/01/05";

		Person pers = new Person("Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124, date);
		Person liz = new Person("Demanou", "Inaya", "female", "Braunschweig", "Gleiwitzstrasse", 38124, liDate);
		Person fr = new Person("Demanou", "Franck", "male", "Braunschweig", "Gleiwitzstrasse", 38124, frDate);

		LOGGER.info(ConvertJavaObjektToJson.jsonValue(pers));

		option.OptionValiedierungsArgument(args);

		ConvertJsonToJvaObject.javaObjectValue(option.getPathFile());

		LocalDate dateFormated = DayMonthYearCalculator.DayMonthYearValue(date);

		DayMonthYearCalculator.tagValue(dateFormated);
		DayMonthYearCalculator.monthValue(dateFormated);
		DayMonthYearCalculator.yearValue(dateFormated);

		DayMonthYearCalculator.convertDateFormat(date.toString());

		PersonDAO personDAO = new PersonDAO();

		/*personDAO.addPerson(liz);
		personDAO.addPerson(fr);
		personDAO.addPerson(pers);*/
		personDAO.addPerson(fr);

		LOGGER.info("Alle Personen:");
		
		for (Person perss: personDAO.getAllPersons()) {
			LOGGER.info(""+perss.toString());	
		}


		//personDAO.updatePersonByFirstName("Franck", fr);
		

		LOGGER.info("FOUND PERSON : " + personDAO.getPerson("Clemence").toString());
		
		personDAO.deletePerson("Franck");
	}

}
