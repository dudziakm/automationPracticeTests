package com.javatest;

import java.io.IOException;
import java.util.Properties;

public class MyProperties {

    private Properties properties;

    public MyProperties() {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(MyProperties.class.getResourceAsStream("my_chrome_path=./chromedriver.exe"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}