package pages.voids.pagesForWebApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.voids.base.BasePageForWeb;

public class DomainNamesPage extends BasePageForWeb {

    @FindBy(xpath = "//*[@id='main_right']/h1")
    private WebElement pageHeader;

    public DomainNamesPage(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getStringPageHeader() {
        return pageHeader.getText();
    }
}
