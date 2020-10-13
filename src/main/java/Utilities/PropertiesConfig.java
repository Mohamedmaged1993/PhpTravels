package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {
    Properties properties;

    public  String getProperty(String value) {
        properties = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("config.properties");

        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(value);

    }

    }
