package com.adesso.insurance.maven;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ConvertJsonToJvaObject {

	public void getJavaObject(String file) {

		Gson gson = new Gson();
		Person person = null;

		try {
			// create java object from json file using gson
			person = gson.fromJson(new FileReader(file), Person.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.print("Das Attribut City aus der json Datei has das Werte : ");
		System.out.println(person.getCity());

	}
			 
}
		

		     
		  

		
		
		
	
	

	
	
	







