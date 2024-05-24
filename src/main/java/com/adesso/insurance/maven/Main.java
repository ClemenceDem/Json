package com.adesso.insurance.maven;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws ParseException, IOException {

		OptionValiedierung option = new OptionValiedierung();
		
		Person pers = new Person("Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124);

		// return json string from java Object
		logger.info(ConvertJavaObjektToJson.getJson(pers));
		
		
		// Validation of the argument with the option
		option.OptionValiedierungsArgument(args);
		
		// return value of city from the json file
		ConvertJsonToJvaObject.getJavaObject(option.getPathFile());

		String date = "1995/02/01";
		
		LocalDate dateFormated = DayMonthYearCalculator.getDayMonthYear(date);
		
		DayMonthYearCalculator.getDay(dateFormated);
		DayMonthYearCalculator.getMonth(dateFormated);
		DayMonthYearCalculator.getYear(dateFormated);
		
		
		DayMonthYearCalculator.convertDateFormat(date.toString());
		
		
		
		
		
      
		
    

	}

	
	}


	
	

    
       
/*
 * // Neue Person erstellen PersonDAO personDAO = new PersonDAO();
 * 
 * pers.setLastname("Demanou"); pers.setFirstname("Clemence");
 * pers.setSex("female"); pers.setCity("Braunschweig");
 * pers.setAddress("Gleiwitzstrasse"); pers.setPostalcode(38124);
 * personDAO.createPerson(pers);
 * 
 * // Person lesen Person p = personDAO.readPerson(pers.getId());
 * System.out.println("Gelesene Person: " + p.getFirstname() + " " +
 * p.getLastname() + p.getSex() + " " + p.getCity() + " " + p.getAddress() +
 * " "+ p.getPostalcode() );
 * 
 * // Person updaten p.setSex("female"); personDAO.updatePerson(p);
 * 
 * // Alle Personen anzeigen List<Person> persons = personDAO.getAllPersons();
 * for (Person per : persons) { System.out.println(per.getFirstname() + " " +
 * per.getLastname()); }
 * 
 * // Person löschen personDAO.deletePerson(p.getId()); } }
 */
