package com.eurotech.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {// configuration.properties i okumak icin bu class gerekli
    private static Properties properties;

    static {
        try {
            //what file to read
            String path = "configuration.properties";// okuma isi burda yapiyor
            //read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);// burasi javanin okumasi icin grekli girrdi
            //properties --> class that store properties in key / value format
            properties = new Properties();
            //the values from the file input is loaded / fed in to the properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //how can we call the configurationReader
    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
