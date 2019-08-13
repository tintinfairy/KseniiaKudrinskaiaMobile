package pages.voids.pagesForWebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


    public String getStringHeaderText() {
        return headerText.getText();
    }

    public void clickDomainNamesHref() {
        domainNamesHref.click();
    }
}