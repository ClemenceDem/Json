package com.adesso.insurance.optionvalidierung;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionValidierung {

	private static final Logger LOGGER = LoggerFactory.getLogger(OptionValidierung.class);
	private static final String PARAM_START = "start";
	private static final String PARAM_STARTS = "s";
	private static String pathfile = null;

	public void OptionValiedierungsArgument(String[] args) throws ParseException {
		final Option ALPHA = new Option(PARAM_STARTS, PARAM_START, true, "dient dazu die App zu starten");

		Options options = new Options();

		options.addOption(ALPHA);

		CommandLine cmd;

		CommandLineParser parser = new DefaultParser();
		HelpFormatter helper = new HelpFormatter();

		try {

			cmd = parser.parse(options, args);

			if (cmd.hasOption("start")) {

				pathfile = cmd.getOptionValue(ALPHA);
				LOGGER.info("Sie haben die App gestartet");
				System.out.println();
			}

			LOGGER.info("Pfad der json Datei ist : " + pathfile);
		} catch (ParseException e) {
			LOGGER.warn(e.getMessage());
			helper.printHelp("Usage : ", options);
			System.exit(0);
		} catch (NullPointerException e) {
			LOGGER.error("Das Attribut pathfile ist möglicherweise an dieser Stelle noch null");
			System.exit(0);
		}
	}

	public String getPathFile() {
		return pathfile;
	}

}
