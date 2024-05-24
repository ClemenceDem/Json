package com.adesso.insurance.maven;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertJavaObjektToJson {

	private static final Logger logger = LoggerFactory.getLogger(ConvertJavaObjektToJson.class);

	public static String getJson(Person person) {

		logger.info("Die JSON-Darstellung des Objekts person ist : ");
		return new Gson().toJson(person);
	}

}


