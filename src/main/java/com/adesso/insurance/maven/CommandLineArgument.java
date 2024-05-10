package com.adesso.insurance.maven;

public class CommandLineArgument {

	public static void main(String[] args) {
		try {
	          // Wenn die Argumente gültig sind, führe hier die Anwendungslogik aus
			     arrayLength(args); 
	           
	            System.out.println("Anwendung gestartet mit den Argumenten: " + String.join(", ", args));

	        } catch (IllegalArgumentException e) {

	            // Wenn die Argumente ungültig sind, fange die Exception ab und gib eine Fehlermeldung aus

	            System.err.println("Fehler beim Starten der Anwendung: " + e.getMessage());
 }
	}	
		
		public static void arrayLength(String[] args){
			
			
			if(args.length != 3) {
				 throw new IllegalArgumentException("Ungültige Anzahl von Argumenten"); 	
			} 
			
			
			if(!args[0].equals("halo world")) {
				 throw new IllegalArgumentException("Argumenten stimmen nicht überein"); 	
			} 
			System.out.println(args[1]);
			
			assert !args[0].equals("hello world");
		    throw new IllegalArgumentException("Argumentenen stimmen nicht überein"); 
		    
	}

}
