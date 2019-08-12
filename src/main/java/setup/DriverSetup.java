package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static enums.BrowserNames.CHROME;
import static enums.BrowserNames.SAFARI;
import static enums.DataToSetProperties.APP_SOURCE;
import static enums.DataToSetProperties.PROTOCOL;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

/**
 * Class which sets up driver and it's capabilities
 * According to chosen platform, device, browser etc.
 */

public class DriverSetup extends TestProperties {

    private static AppiumDriver driver;
    private WebDriverWait wait;
    private DesiredCapabilities capabilities;
    protected String AUT;
    protected String SUT;
    private String platformName;
    private String driverAddress;
    private String device;
    private String browser;

    public DriverSetup() throws IOException {

        String nativeApp = getProperty("aut");
        AUT = (nativeApp == null) ? null : APP_SOURCE.getElement() + nativeApp;
        String testingSite = getProperty("sut");
        SUT = (testingSite == null) ? null : PROTOCOL.getElement() + testingSite;
        platformName = getProperty("platform");
        driverAddress = getProperty("driver");
        device = getProperty("device");

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
        capabilities.setCapability(PLATFORM_NAME, platformName);
        switch (platformName) {
            case "Android": {
                capabilities.setCapability(DEVICE_NAME, device);
                browser = CHROME.getBrowserName();
                setCapabilitiesDependingOnAppType();
                driver = new AndroidDriver(new URL(driverAddress), capabilities);
                break;
            }
            case "iOS": {
                browser = SAFARI.getBrowserName();
                setCapabilitiesDependingOnAppType();
                driver = new IOSDriver(new URL(driverAddress), capabilities);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown Mobile Platform");
        }
        return driver;
    }

    /**
     * This method guarantees that we have only one type of app
     * There cannot be hybrid, only native or only web
     */
    private void setCapabilitiesDependingOnAppType() {
        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(BROWSER_NAME, browser);
        } else {
            throw new IllegalArgumentException("Unclear type of mobile app");
        }
    }

}