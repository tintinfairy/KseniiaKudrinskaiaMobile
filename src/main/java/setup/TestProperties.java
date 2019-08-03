package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class which works with data from property files
 */
public class TestProperties {

    private Properties properties;
    protected String token;

    Properties getCurrentProperties() throws IOException {
        properties = new Properties();
        FileInputStream in = new FileInputStream(System.getProperty("property"));
        properties.load(in);
        in.close();
        token = System.getProperty("token");
        return properties;
    }

    protected String getProperty(String propKey) throws IOException {
        if (properties == null) {
            properties = getCurrentProperties();
        }
        return properties.getProperty(propKey, null);
    }
}
