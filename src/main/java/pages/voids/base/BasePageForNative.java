package pages.voids.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageForNative {
    protected AppiumDriver driver;
    public BasePageForNative(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}