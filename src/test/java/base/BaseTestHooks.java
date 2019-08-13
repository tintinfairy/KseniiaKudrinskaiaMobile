package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.DriverSetup;

import java.io.IOException;

/**
 * Class to implement hooks
 */

public class BaseTestHooks extends DriverSetup {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BaseTestHooks() throws IOException {
    }

    /**
     * Set up our environment: driver and wait
     */
    @BeforeSuite
    public void setUp() {
        driver = getDriver();
        wait = getWebDriverWait();
    }

    /**
     * Tear down connection
     * Quit driver and make wait null
     */
    @AfterSuite
    public void tearDown() {
        driver.quit();
        driver = null;
        wait = null;
    }
}