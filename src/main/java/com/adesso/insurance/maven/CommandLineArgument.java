package com.adesso.insurance.maven;

public class CommandLineArgument {
	
	
	public static void arrayLength(String[] args) {

		// wenn die länge ungleich 3 ist
		if (args.length != 3) {
			throw new IllegalArgumentException("Ungültige Anzahl von Argumenten");
		}

		// wenn das erste Argument mit dem in die Konsole eingegebene Wort nicht übereinstimmt
		if (!args[0].equals("life is beautiful")) {
			throw new IllegalArgumentException("Argument an dieser Position stimmt nicht überein");
		}

		// wenn das Ende des Arguments mit dem in die Konsole eingegebene Wort nicht übereinstimmt
		if (!args[2].endsWith("xx")) {
		throw new IllegalArgumentException("Das eingegebene Ende stimmt nicht mit dem Wort überein");
		}

	}
	
	
	

	public static void main(String[] args) {
		try {
			// Wenn die Argumente gültig sind, führe hier die Anwendungslogik aus
			arrayLength(args);

			System.out.println("Anwendung gestartet mit den Argumenten: " + String.join(", ", args));

		} catch (IllegalArgumentException e) {

			// Wenn die Argumente ungültig sind, fange die Exception ab und gib eine
			// Fehlermeldung aus

			System.err.println("Fehler beim Starten der Anwendung: " + e.getMessage());
		}
	}

}
