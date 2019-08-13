package pages.voids.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetup;

import java.net.MalformedURLException;

/**
 * Abstract class wh=ich extends by pages for Native App
 * Because they have similar constructors
 */
public abstract class BasePageForNative {
    public BasePageForNative() {
        try {
            AppiumDriver driver = DriverSetup.getDriver();
            PageFactory.initElements(driver, this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


}