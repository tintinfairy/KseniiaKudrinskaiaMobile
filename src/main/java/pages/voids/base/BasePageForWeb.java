package pages.voids.base;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class wh=ich extends by pages for Web App
 * Because they have similar constructors
 */
public abstract class BasePageForWeb {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePageForWeb(AppiumDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


}