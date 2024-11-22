package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {


    //1- Create the Properties object (create object)
    //make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else.
    private static final Properties properties = new Properties();

    static{
        try (InputStream inputStream = new FileInputStream("configuration.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }

}
