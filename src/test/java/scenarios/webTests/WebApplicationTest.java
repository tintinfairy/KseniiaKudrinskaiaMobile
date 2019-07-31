package scenarios.webTests;

import base.BaseTestHooks;
import org.testng.annotations.Test;
import pages.voids.pagesForWebApp.DomainNamesPage;
import pages.voids.pagesForWebApp.HomePage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Test class
 * With PageObject Pattern implementation
 */

public class WebApplicationTest extends BaseTestHooks {
    public WebApplicationTest() throws IOException {
    }

    @Test(description = "This test opens web page, assert header on it, clicks element to move to another page and assert it's page header")
    public void simpleTestsOnWebApplication() {
        String headerText = "The global coordination of the DNS Root, IP addressing, " +
                "and other Internet protocol resources is performed as the " +
                "Internet Assigned Numbers Authority (IANA) functions. " +
                "Learn more.";
        String domainPageHeader = "Domain Name Services";
        //Open web page
        driver.get(SUT);
        HomePage homePage = new HomePage(driver, wait);
        //Assert that "Home page" has expected header
        assertEquals(homePage.getStringHeaderText(), headerText);
        //Click on "Domain Name" clickable link
        homePage.clickDomainNamesHref();
        DomainNamesPage domainNamesPage = new DomainNamesPage(driver, wait);
        //Assert that header on "Domain Names" page has expected header
        assertEquals(domainNamesPage.getStringPageHeader(), domainPageHeader);

    }


}
