package steps.webApp;

import base.BaseTestHooks;
import pages.voids.pagesForWebApp.HomePage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
/**
 * Test class
 * With Steps Pattern implementation
 */
public class HomePageSteps extends BaseTestHooks {

    HomePage homePage;
    public HomePageSteps() throws IOException {
        homePage = new HomePage(driver, wait);
    }

    public void openWebPage(String page) {
        driver.get(page);
    }

    public void mainHeaderAssertion(String headerText) {
        assertEquals(homePage.getStringHeaderText(), headerText);
    }

    public void clickDomainNamesHref(){
        homePage.clickDomainNamesHref();
    }
}
