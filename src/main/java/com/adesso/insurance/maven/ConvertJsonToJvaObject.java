package com.adesso.insurance.maven;

import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ConvertJsonToJvaObject {
	// create a logger
	private static final Logger logger = LoggerFactory.getLogger(ConvertJsonToJvaObject.class);

	public static Person getJavaObject(String pathfile) throws IOException  {
		// create a new Gson object.
		Gson gson = new Gson();
		Person person = null;

		try {
			person = gson.fromJson(new FileReader(pathfile), Person.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		logger.info("Das Attribut City aus der json Datei has das Werte : " + person.getCity());

		return person;
	}

}
