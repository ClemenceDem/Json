package com.adesso.insurance.convert;

import com.adesso.insurance.dao.Person;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertJavaObjektToJson {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvertJavaObjektToJson.class);

	public static String jsonValue(Person person) {

		LOGGER.info("Die JSON-Darstellung des Objekts person ist : ");
		return new Gson().toJson(person);
	}

}


