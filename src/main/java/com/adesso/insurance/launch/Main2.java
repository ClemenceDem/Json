package com.adesso.insurance.launch;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adesso.insurance.convert.ConvertJavaObjektToJson;
import com.adesso.insurance.convert.ConvertJsonToJvaObject;
import com.adesso.insurance.dao.Person;
import com.adesso.insurance.optionvalidierung.OptionValidierung;

public class Main2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {

        OptionValidierung option = new OptionValidierung();

        String date = "1995/02/01";

        Person pers = new Person("Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124, date);

        LOGGER.info(ConvertJavaObjektToJson.jsonValue(pers));

        option.OptionValiedierungsArgument(args);

        ConvertJsonToJvaObject.javaObjectValue(option.getPathFile());



    }

}
