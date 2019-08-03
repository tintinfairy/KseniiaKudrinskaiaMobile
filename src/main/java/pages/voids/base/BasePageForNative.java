package pages.voids.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstract class wh=ich extends by pages for Native App
 * Because they have similar constructors
 */
public abstract class BasePageForNative {
    protected AppiumDriver driver;
    public BasePageForNative(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}