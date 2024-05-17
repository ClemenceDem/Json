package com.adesso.insurance.maven;

import org.apache.commons.cli.ParseException;

public class Main {
	
	public static void main(String[] args) throws ParseException {
		ConvertToJson conv = new ConvertToJson();
		ConvertJsonToJvaObject con = new ConvertJsonToJvaObject();
		OptionValiedierung opt = new OptionValiedierung();

		Person pers = new Person("Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124);

		// return json string from java Object
		conv.getJson(pers);
		
				
		// Validation of the argument with the option
		opt.OptionValiedierungsArgument(args);


		// return value of city from the json file
		con.getJavaObject(opt.getPathFile());

	}

}
