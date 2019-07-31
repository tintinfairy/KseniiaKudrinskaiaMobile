package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    final static String FILE_PATH = "src/main/resources/testnative.properties";
    private Properties properties;

    Properties getCurrentProperties() throws IOException {
        properties = new Properties();
        FileInputStream in = new FileInputStream(System.getProperty("property"));
        properties.load(in);
        in.close();
        return properties;
    }

    protected String getProperty(String propKey) throws IOException {
        if (properties == null) {
            properties = getCurrentProperties();
        }
        return properties.getProperty(propKey, null);
    }
}
