package com.adesso.insurance.maven;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionValiedierung {

	private static final Logger logger = LoggerFactory.getLogger(OptionValiedierung.class);
	private static final String PARAM_START = "start";
	private static final String PARAM_STARTS = "s";
	private static String pathfile = null;

	public void OptionValiedierungsArgument(String[] args) throws ParseException {
		final Option ALPHA = new Option(PARAM_STARTS, PARAM_START, true, "dient dazu die App zu starten");

		// new collection of Options
		Options options = new Options();
		// add an option to the collection of Options
		options.addOption(ALPHA);

		// Representation of a list of parsed arguments
		CommandLine cmd;
		// CommandLineParser for parsing a string
		CommandLineParser parser = new DefaultParser();
		HelpFormatter helper = new HelpFormatter();

		try {
			// parsing arguments
			cmd = parser.parse(options, args);

			if (cmd.hasOption("start")) {
				// get the argument of the Options object
				pathfile = cmd.getOptionValue(ALPHA);
				logger.info("Sie haben die App gestartet");
				System.out.println();
			}

			logger.info("Pfad der json Datei ist : " + pathfile);
		} catch (ParseException e) {
			logger.warn(e.getMessage());
			helper.printHelp("Usage : ", options);
			System.exit(0);
		} catch (NullPointerException e) {
			logger.error("Das Attribut pathfile ist möglicherweise an dieser Stelle noch null");
			System.exit(0);
		}
	}

	public String getPathFile() {
		return pathfile;
	}

}
