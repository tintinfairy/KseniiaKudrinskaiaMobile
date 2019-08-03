package steps.webApp;

import base.BaseTestHooks;
import pages.voids.pagesForWebApp.DomainNamesPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Test class
 * With Steps Pattern implementation
 */
public class DomainNamesPageSteps extends BaseTestHooks {
    DomainNamesPage domainNamesPage;
    public DomainNamesPageSteps() throws IOException {
        domainNamesPage = new DomainNamesPage(driver, wait);
    }

    public void mainHeaderAssertion(String domainPageHeader) {
        assertEquals(domainNamesPage.getStringPageHeader(), domainPageHeader);
    }
}
