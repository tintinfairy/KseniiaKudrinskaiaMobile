package scenarios.webTests;

import base.BaseTestHooks;
import org.testng.annotations.Test;
import pages.voids.pagesForWebApp.DomainNamesPage;
import pages.voids.pagesForWebApp.HomePage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class WebApplicationTest extends BaseTestHooks {
    public WebApplicationTest() throws IOException {
    }

    @Test
    public void simpleTestsOnWebApplication() {
        String headerText = "The global coordination of the DNS Root, IP addressing, " +
                "and other Internet protocol resources is performed as the " +
                "Internet Assigned Numbers Authority (IANA) functions. " +
                "Learn more.";
        String domainPageHeader = "Domain Name Services";
        driver.get(SUT);
        HomePage homePage = new HomePage(driver, wait);
        assertEquals(homePage.getStringHeaderText(), headerText);
        homePage.clickDomainNamesHref();
        DomainNamesPage domainNamesPage = new DomainNamesPage(driver, wait);
        assertEquals(domainNamesPage.getStringPageHeader(), domainPageHeader);

    }


}
