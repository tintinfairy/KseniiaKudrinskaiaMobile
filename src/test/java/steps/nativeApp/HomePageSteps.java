package steps.nativeApp;

import base.BaseTestHooks;
import enums.ContactNames;
import pages.voids.pagesForNativeApp.HomePage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Test class
 * With Steps Pattern implementation
 */
public class HomePageSteps extends BaseTestHooks {
    static HomePage homePage;

    public HomePageSteps() throws IOException {
        homePage = new HomePage();
    }

    public void expectedTitleAssertion(String title) {
        assertEquals(homePage.getTitleText(), title);
    }

    public void clickContactButton() {
        homePage.clickAddContactButton();
    }


    public void chosenContactIsAdded(ContactNames name) {
        assertTrue(homePage.checkIfContactsAreShown(name));
    }
}
