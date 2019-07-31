package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetUp {
    protected AppiumDriver driver;

    protected void prepareNative() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        //capabilities.setCapability("device","Android"); // mandatory???????
        capabilities.setCapability("deviceName","HT7281202375");
        capabilities.setCapability("platformName","Android");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location,
// e.g. "resources" folder of the project
        File appDir = new File			("C:\\Users\\Admin\\IdeaProjects\\MyFirstAppiumTest\\src\\main\\resources\\");
        File app = new File(appDir, "ContactManager.apk");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

// Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}
