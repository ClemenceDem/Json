package com.adesso.insurance.application;


import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adesso.insurance.dao.PersonDAO;
import com.adesso.insurance.entity.Person;

public class PersonDAOMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAOMain.class);

	public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {

        Person pers = new Person(1, "Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124, "1992/03/21");
        Person liz = new Person(2, "Demanou", "Inaya", "female", "Braunschweig", "Gleiwitzstrasse", 38124, "2022/10/29");
        Person fr = new Person(3, "Demanou", "Franck", "male", "Braunschweig", "Gleiwitzstrasse", 38124, "1991/01/05");

        PersonDAO.addPerson(pers);
        PersonDAO.addPerson(liz);
        PersonDAO.addPerson(fr);

        LOGGER.info("Alle Personen:");

        for (Person perss : PersonDAO.getAllPersons()) {
            LOGGER.info("" + perss.toString());
        }

	}

}
