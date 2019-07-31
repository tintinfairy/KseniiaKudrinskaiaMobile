package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.DriverSetup;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTestHooks extends DriverSetup {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BaseTestHooks() throws IOException {
    }

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        driver = getDriver();
        wait = getWebDriverWait();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        driver = null;
        wait = null;
    }
}
