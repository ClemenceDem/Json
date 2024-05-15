package com.adesso.insurance.maven;


import org.apache.commons.cli.*;

public class CommandLineArgument {
	
	// definiere eine leere Kollektion von Options
	static Options options = new Options();
	
	// Erstellung eines option Objekts
	static Option ALPHA = new Option("s", "start", true, "dient dazu die App zu starten");

	 
	
    public static void main(String[] args) throws ParseException {
    	
		ConvertJsonToJvaObject con = new ConvertJsonToJvaObject();	

		// Hinfügen des option Objekts in die Kollektion
		options.addOption(ALPHA);

		// definiere von parser
		CommandLine cmd;
		CommandLineParser parser = new DefaultParser();
		HelpFormatter helper = new HelpFormatter();

		try {
			cmd = parser.parse(options, args);
			String pathfile = null;

			if (cmd.hasOption("start")) {
				// get Argument des option Objekts
				pathfile = cmd.getOptionValue(ALPHA);
				System.out.println("Pfad der json Datei : " + pathfile);
				System.out.println();
			}
			
			// return value of city from the json file
			con.getJavaObject(pathfile);

		} catch (ParseException e) {
			System.out.println(e.getMessage());
			helper.printHelp("Usage : ", options);
			System.exit(0);
		} catch (NullPointerException e) {
			System.out.println("Das Attribut pathfile ist möglicherweise an dieser Stelle noch null");
			System.exit(0);
		}
	}

}


    
