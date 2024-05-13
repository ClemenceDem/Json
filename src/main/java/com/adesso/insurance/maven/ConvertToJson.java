package com.adesso.insurance.maven;

import com.google.gson.Gson;

public class ConvertToJson {
	

	public void getJson(Person person) {
		System.out.println( "Die JSON-Darstellung des Objekts person ist : " );
		System.out.println(new Gson().toJson(person));	
	}

}
