package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.DriverSetup;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Class to implement hooks
 */
@Test(groups = {"web", "native"})
public class BaseTestHooks extends DriverSetup {
    protected static AppiumDriver driver;
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
     * Close application and make wait null
     */
    @AfterSuite
    public void tearDown() {
        driver.closeApp();
        driver = null;
        wait = null;
    }
}
