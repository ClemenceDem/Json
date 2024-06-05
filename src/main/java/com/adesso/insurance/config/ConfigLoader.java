package com.adesso.insurance.config;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigLoader {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigLoader.class);
    private static CombinedConfiguration config;

    static {
        Configurations configurations = new Configurations();
        try {

            PropertiesConfiguration propertiesConfiguration = configurations.properties("dbconfig.properties");
            config = new CombinedConfiguration();
            config.addConfiguration(propertiesConfiguration);
        } catch (ConfigurationException e) {

            LOGGER.error("properties wurden nicht geladen");

        }
    }

    public static String getProperty(String key) {
        return config.getString(key);
    }
}


