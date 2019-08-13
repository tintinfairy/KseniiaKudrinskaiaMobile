package pages.voids.base;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverSetup;

import java.net.MalformedURLException;

/**
 * Abstract class wh=ich extends by pages for Web App
 * Because they have similar constructors
 */
public abstract class BasePageForWeb {

    public BasePageForWeb() {
        try {
            AppiumDriver driver = DriverSetup.getDriver();
            WebDriverWait wait = DriverSetup.getWebDriverWait();
            PageFactory.initElements(driver, this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


}