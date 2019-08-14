package scenarios.webTests;

import base.BaseTestHooks;
import org.testng.annotations.Test;
import steps.webApp.DomainNamesPageSteps;
import steps.webApp.HomePageSteps;

import java.io.IOException;

/**
 * Test class
 * With PageObject Pattern implementation
 */

@Test(groups = "web")
public class WebApplicationTest extends BaseTestHooks {
    public WebApplicationTest() throws IOException {
    }

    public void simpleTestsOnWebApplication() throws IOException {
        String headerText = "The global coordination of the DNS Root, IP addressing, " +
                "and other Internet protocol resources is performed as the " +
                "Internet Assigned Numbers Authority (IANA) functions. " +
                "Learn more.";
        String domainPageHeader = "Domain Name Services";
        HomePageSteps homePageSteps = new HomePageSteps();
        //Open web page
        homePageSteps.openWebPage(SUT);
        //Assert that "Home page" has expected header
        homePageSteps.mainHeaderAssertion(headerText);
        //Click on "Domain Name" clickable link
        homePageSteps.clickDomainNamesHref();
        DomainNamesPageSteps domainNamesPageSteps = new DomainNamesPageSteps();
        //Assert that header on "Domain Names" page has expected header
        domainNamesPageSteps.mainHeaderAssertion(domainPageHeader);

    }


}
