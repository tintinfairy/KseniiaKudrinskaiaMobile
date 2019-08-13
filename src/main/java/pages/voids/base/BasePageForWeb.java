package pages.voids.base;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverSetup;

/**
 * Abstract class wh=ich extends by pages for Web App
 * Because they have similar constructors
 */
public abstract class BasePageForWeb {

    public BasePageForWeb() {
        AppiumDriver driver = DriverSetup.getDriver();
        WebDriverWait wait = DriverSetup.getWebDriverWait();
        PageFactory.initElements(driver, this);


    }


}