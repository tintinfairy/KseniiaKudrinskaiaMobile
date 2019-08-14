package pages.voids.pagesForWebApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.voids.base.BasePageForWeb;

/**
 * Page to implement PageObject Pattern for Web App
 * Includes elements search and actions with them
 */
public class DomainNamesPage extends BasePageForWeb {

    @FindBy(xpath = "//*[@id='main_right']/h1")
    private WebElement pageHeader;


    public String getStringPageHeader() {
        return pageHeader.getText();
    }
}