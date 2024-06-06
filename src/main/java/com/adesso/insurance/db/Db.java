package com.adesso.insurance.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Db {

    private static Connection conn = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(Db.class);

    public static Connection getConnection() {
        try {
            Properties props = loadProperties();
            String url = props.getProperty("URL");
            String user = props.getProperty("USER");
            String pass = props.getProperty("PASSWORD");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            LOGGER.error("" + e.getMessage());
        }
        return conn;
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (FileInputStream fs = new FileInputStream("src/main/resources/properties/dbConfig.properties")) {
            props.load(fs);
            if (props != null) {
                return props;
            }
        } catch (IOException e) {
            LOGGER.error("" + e.getMessage());
        }
        return props;
    }

}
