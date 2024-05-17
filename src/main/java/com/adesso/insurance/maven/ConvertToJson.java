package com.adesso.insurance.maven;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertToJson {
	
	private static final Logger logger = LoggerFactory.getLogger(MyAppLogger.class);


	public void getJson(Person person) {
		logger.info( "Die JSON-Darstellung des Objekts person ist : "+new Gson().toJson(person));
	}

}
