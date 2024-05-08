package com.adesso.insurance.maven;

import com.google.gson.Gson;

public class ConvertToJson {

	public static void main(String[] args) {


		Person pers= new Person("Demanou","Clemence",
				"female","Braunschweig","Gleiwitzstrasse",38124);
		
		
		System.out.println( "Die JSON-Darstellung des Objekts person ist" );
		System.out.println(new Gson().toJson(pers));	
     
	}

}
