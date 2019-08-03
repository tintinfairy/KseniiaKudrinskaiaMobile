package steps.nativeApp;

import base.BaseTestHooks;
import enums.ContactNames;
import pages.voids.pagesForNativeApp.HomePage;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Test class
 * With Steps Pattern implementation
 */
public class HomePageSteps extends BaseTestHooks {
    static HomePage homePage;
    public HomePageSteps() throws IOException {
        homePage = new HomePage(driver);
    }

    public void expectedTitleAssertion(String title) {
        assertEquals(homePage.getTitleText(), title);
    }

    public void clickContactButton() {
        homePage.clickAddContactButton();
    }

    public void chosenContactIsAdded(ContactNames name) {
        assertThat(homePage.getStringContactList(), hasItem(name.getName()));
    }
}
