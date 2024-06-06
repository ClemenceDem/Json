package com.adesso.insurance.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adesso.insurance.convert.ConvertJavaObjektToJson;
import com.adesso.insurance.convert.ConvertJsonToJvaObject;
import com.adesso.insurance.entity.Person;
import com.adesso.insurance.optionvalidierung.OptionValidierung;

public class ConvertDataMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConvertDataMain.class);

    public static void main(String[] args) throws Exception {

        OptionValidierung option = new OptionValidierung();

        Person pers = new Person(1, "Demanou", "Clemence", "female", "Braunschweig", "Gleiwitzstrasse", 38124, "1995/02/01");

        LOGGER.info(ConvertJavaObjektToJson.jsonValue(pers));

        option.OptionValiedierungsArgument(args);

        ConvertJsonToJvaObject.javaObjectValue(option.getPathFile());

    }

}
