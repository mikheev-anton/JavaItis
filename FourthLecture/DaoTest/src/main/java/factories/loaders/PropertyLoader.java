package factories.loaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final String IOC_CONFIG_FILE_PATH;

    private static Properties properties;

    static {
        IOC_CONFIG_FILE_PATH = "src\\main\\resources\\ioc.properties";
        properties = new Properties();
        try {
            properties.load(new FileInputStream(IOC_CONFIG_FILE_PATH));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
