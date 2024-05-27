package com.adesso.insurance.maven;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertJavaObjektToJson {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvertJavaObjektToJson.class);

	public static String getJson(Person person) {

		LOGGER.info("Die JSON-Darstellung des Objekts person ist : ");
		return new Gson().toJson(person);
	}

}


