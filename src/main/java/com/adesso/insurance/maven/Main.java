package com.adesso.insurance.maven;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

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
		Person fr = new Person("Demanou", "Franck", "female", "Braunschweig", "Gleiwitzstrasse", 38124, frDate);

		LOGGER.info(ConvertJavaObjektToJson.jsonValue(pers));

		option.OptionValiedierungsArgument(args);

		ConvertJsonToJvaObject.javaObjectValue(option.getPathFile());

		

		LocalDate dateFormated = DayMonthYearCalculator.DayMonthYearValue(date);

		DayMonthYearCalculator.tagValue(dateFormated);
		DayMonthYearCalculator.monthValue(dateFormated);
		DayMonthYearCalculator.yearValue(dateFormated);

		DayMonthYearCalculator.convertDateFormat(date.toString());
		
		
		
		 
		 PersonDAO personDAO = new PersonDAO();

	        // Personen hinzufügen
	        personDAO.addPerson(liz);
	       

	        // Alle Personen abrufen
	        System.out.println("Alle Personen:");
	        personDAO.getAllPersons().forEach(System.out::println);

	        // Eine Person abrufen
	        System.out.println("Person mit ID 1:");
	        personDAO.getPerson("Franck").ifPresent(System.out::println);

	        // Eine Person aktualisieren
	        System.out.println("Person mit ID 1 aktualisieren:");
	        personDAO.updatePerson(fr);
	        personDAO.getPerson("Inaya").ifPresent(System.out::println);

	        // Eine Person löschen
	        System.out.println("Person mit lastname Demanou löschen:");
	        personDAO.deletePerson("Clemence");
	        personDAO.getAllPersons().forEach(System.out::println);
	}

}
