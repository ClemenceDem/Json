package com.adesso.insurance.maven;


public class Main {

	public static void main(String[] args) {
		
		String file = "Person.json";
		
		Person pers= new Person("Demanou","Clemence",
				"female","Braunschweig","Gleiwitzstrasse",38124);
		
		ConvertToJson conv = new ConvertToJson();
		ConvertJsonToJvaObject con = new ConvertJsonToJvaObject();
		
		// return json string from java Object
		conv.getJson(pers);
		
		System.out.println();
		
		// return value of city from the json file
		con.getJavaObject(file);

	}

}
