package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    private static final String CONFIGURATION_PATH = "configuration.properties";

    private static ConfigurationLoader loader;
    private static Properties properties;

    private ConfigurationLoader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIGURATION_PATH));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ConfigurationLoader getInstance() {
        if(loader == null) {
            loader = new ConfigurationLoader();
        }
        return loader;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
