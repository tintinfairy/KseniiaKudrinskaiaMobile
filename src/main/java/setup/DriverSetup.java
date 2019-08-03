package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static enums.BrowserNames.SAFARI;
import static enums.DataToSetProperties.SITE_PROTOCOL;
import static enums.DriverAddress.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

/**
 * Class which sets up driver and it's capabilities
 * According to chosen platform, device, browser etc.
 */

public class DriverSetup extends TestProperties {

    private static AppiumDriver driver;
    private WebDriverWait wait;
    private DesiredCapabilities capabilities;
    protected String SUT;
    private String platformName;
    private String driverAddress;
    private String device;
    private String browser;
    private String appPackage;
    private String appActivity;
    private String testType;

    public DriverSetup() throws IOException {

        testType = getProperty("testType");
        String testingSite = getProperty("sut");
        SUT = (testingSite == null) ? null : SITE_PROTOCOL.getElement() + testingSite;
        platformName = getProperty("platform");
        driverAddress = PROTOCOL.getEntity() + APP_TYPE.getEntity() + token + MOBILE_CLOUD.getEntity();
        device = getProperty("device");
        appPackage = getProperty("appPackage");
        appActivity = getProperty("appActivity");


    }

    /**
     * Singleton pattern to have only one instance of driver
     */
    protected AppiumDriver getDriver() throws MalformedURLException {
        if (null == driver) {
            driver = prepareDriver();
        }
        return driver;
    }

    /**
     * Singleton pattern to have only one instance of wait
     */
    protected WebDriverWait getWebDriverWait() throws MalformedURLException {
        if (null == wait) {
            wait = new WebDriverWait(getDriver(), 10);
        }
        return wait;
    }

    /**
     * This method helps us to choose capabilities for chosen platform automatically
     */
    private AppiumDriver prepareDriver() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(UDID, device);
        capabilities.setCapability(PLATFORM_NAME, platformName);
        switch (testType) {
            case "web": {
                browser = SAFARI.getBrowserName();
                capabilities.setCapability(BROWSER_NAME, browser);
                driver = new IOSDriver(new URL(driverAddress), capabilities);
                break;
            }
            case "native": {
                capabilities.setCapability(APP_PACKAGE, appPackage);
                capabilities.setCapability(APP_ACTIVITY, appActivity);
                driver = new AndroidDriver(new URL(driverAddress), capabilities);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown Mobile Platform");
        }
        return driver;
    }


}
