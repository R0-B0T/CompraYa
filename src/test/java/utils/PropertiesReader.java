package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static final String CONFIG_FILE = "src/test/resources/config/config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo cargar el archivo de configuración");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}