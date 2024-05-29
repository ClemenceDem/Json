package com.adesso.insurance.maven;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class ConvertJavaObjektToJsonTest {
	
	@Test
	//ConvertJavaObjektToJson
	public void testGetJson() throws ParseException {
		Person pers = new Person("Demanou","Clemence","Female","Braunschweig","Gleiwitzstrasse", 38124, "1995-02-01");
		String json = "{\"lastname\":\"Demanou\",\"firstname\":\"Clemence\",\"sex\":\"Female\",\"city\":\"Braunschweig\",\"address\":\"Gleiwitzstrasse\",\"postalcode\":38124,\"birthdate\":\"1995-02-01\"}";
		
		assertEquals(ConvertJavaObjektToJson.jsonValue(pers),json);
	}


}
