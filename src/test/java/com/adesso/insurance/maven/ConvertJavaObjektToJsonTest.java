package com.adesso.insurance.maven;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ConvertJavaObjektToJsonTest {
	
	@Test
	//ConvertJavaObjektToJson
	public void testJsonValue() throws ParseException {
		Person pers = new Person("Demanou","Clemence","Female","Braunschweig","Gleiwitzstrasse", 38124, "1995-02-01");
		String json = "{\"lastname\":\"Demanou\",\"firstname\":\"Clemence\",\"gender\":\"Female\",\"city\":\"Braunschweig\",\"street\":\"Gleiwitzstrasse\",\"birthDate\":\"1995-02-01\",\"postalcode\":38124}";
		
		assertEquals(ConvertJavaObjektToJson.jsonValue(pers),json);
	}
	
	
	@Test
	public void testGetPerson() throws ParseException, SQLException, java.text.ParseException {

		Person person = new Person("Demanou", "Franck", "male", "Braunschweig", "Gleiwitzstrasse", 38124, "1991-01-05");		
		Person myPerson = PersonDAO.getPerson("Franck");
	
		Boolean result = person.compareTo(myPerson);

		assertEquals(result, true);
	}
	
	
	@Test
	public void testGetAllPerson() throws ParseException, SQLException, java.text.ParseException {

		List<Person> persons = new ArrayList<>();
		Person person = new Person("Demanou", "Franck", "male", "Braunschweig", "Gleiwitzstrasse", 38124, "1991-01-05");		
		Person pers = new Person("Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124, "1992-03-21");
		Person liz = new Person("Demanou", "Inaya", "female", "Braunschweig", "Gleiwitzstrasse", 38124, "2022-10-29");
		
		persons.add(pers);
		persons.add(liz);
		persons.add(person);
		
		List<Person> result = PersonDAO.getAllPersons();
		
		Boolean comp = compareListByPosition(persons, result);

		assertEquals(comp, true);
	}
	
	
	private Boolean compareListByPosition(List<Person> pers1, List<Person> pers2) {
		if (pers1.size() != pers2.size()) {
			return false;
		}
		
		for (int i = 0; i < pers1.size(); i++) {
			if (!pers1.get(i).compareTo(pers2.get(i))) {
				return false;
			}	
		}
		
		return true;
	}

}
