package com.adesso.insurance.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConvertJavaObjektToJsonTest {
	
	@Test
	//ConvertJavaObjektToJson
	public void testGetJson() {
		Person pers = new Person("Demanou","Clemence","Female","Braunschweig","Gleiwitzstrasse", 38124);
		String json = "{\"lastname\":\"Demanou\",\"firstname\":\"Clemence\",\"sex\":\"Female\",\"city\":\"Braunschweig\",\"address\":\"Gleiwitzstrasse\",\"postalcode\":38124}";
		
		assertEquals(ConvertJavaObjektToJson.jsonValue(pers),json);
	}


}
