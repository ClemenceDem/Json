package com.adesso.insurance.maven;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ConvertJsonToJvaObjectTest {
	
	@Test
	//ConvertJsonToJvaObject
	public void testGetJavaObject() throws JsonProcessingException, IOException   {
		String pathfile = "Person.json";
		Person pers = new Person("Demanou","Clemence","Female","Braunschweig","Gleiwitzstrasse", 38124,"1995-02-01");
		
		assertEquals(ConvertJsonToJvaObject.getJavaObject(pathfile).getAddress(), pers.getAddress());
	}
	
	
	
}
