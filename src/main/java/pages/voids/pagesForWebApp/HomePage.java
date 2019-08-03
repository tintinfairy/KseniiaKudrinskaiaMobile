package pages.voids.pagesForWebApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.voids.base.BasePageForWeb;

/**
 * Page to implement PageObject Pattern for Web App
 * Includes elements search and actions with them
 */

public class HomePage extends BasePageForWeb {

    @FindBy(xpath = "/html/body/div[@class='homepage']/header")
    private WebElement headerText;

    @FindBy(xpath = "//*[@id='home-panel-domains']/h2/a")
    private WebElement domainNamesHref;

    public HomePage(AppiumDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getStringHeaderText() {
        return headerText.getText();
    }

    public void clickDomainNamesHref() {
        domainNamesHref.click();
    }
}
