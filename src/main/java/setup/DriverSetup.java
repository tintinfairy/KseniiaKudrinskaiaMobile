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
    private static WebDriverWait wait;
    private static DesiredCapabilities capabilities;
    protected static String SUT;
    private static String platformName;
    private static String driverAddress;
    private static String device;
    private static String browser;
    private static String appPackage;
    private static String appActivity;
    private static String AUT;

    public DriverSetup() throws IOException {

        AUT = getProperty("aut");
        String testingSite = getProperty("sut");
        SUT = (testingSite == null) ? null : SITE_PROTOCOL.getElement() + testingSite;
        platformName = getProperty("platform");
        driverAddress = getProperty("driverAddress");
        device = getProperty("device");
        appPackage = getProperty("appPackage");
        appActivity = getProperty("appActivity");


    }

    /**
     * Singleton pattern to have only one instance of driver
     */
    public static AppiumDriver getDriver() {
        try {
            if (null == driver) {
                driver = prepareDriver();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    /**
     * Singleton pattern to have only one instance of wait
     */
    public static WebDriverWait getWebDriverWait() {
        if (null == wait) {
            wait = new WebDriverWait(getDriver(), 10);
        }
        return wait;
    }

    /**
     * This method helps us to choose capabilities for chosen platform automatically
     */
    private static AppiumDriver prepareDriver() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(UDID, device);
        capabilities.setCapability(PLATFORM_NAME, platformName);
        switch (platformName) {
            case "iOS": {
                System.out.println("WEB");
                browser = SAFARI.getBrowserName();
                setCapabilitiesDependingOnAppType();
                driver = new IOSDriver(new URL(driverAddress), capabilities);
                break;
            }
            case "Android": {
                System.out.println("NATIVE");
                setCapabilitiesDependingOnAppType();
                driver = new AndroidDriver(new URL(driverAddress), capabilities);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown Mobile Platform");
        }
        return driver;
    }

    private static void setCapabilitiesDependingOnAppType() {
        if (AUT != null && SUT == null) {
            capabilities.setCapability(APP_PACKAGE, appPackage);
            capabilities.setCapability(APP_ACTIVITY, appActivity);
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(BROWSER_NAME, browser);
        } else {
            throw new IllegalArgumentException("Unclear type of mobile app");
        }
    }
}





