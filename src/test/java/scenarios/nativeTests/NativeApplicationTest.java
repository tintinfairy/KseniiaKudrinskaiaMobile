package scenarios.nativeTests;

import base.BaseTestHooks;
import enums.ContactNames;
import enums.ContactNumbers;
import org.testng.annotations.Test;
import pages.voids.pagesForNativeApp.AddContactPage;
import pages.voids.pagesForNativeApp.HomePage;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Test class
 * With PageObject Pattern implementation
 */
public class NativeApplicationTest extends BaseTestHooks {
    public NativeApplicationTest() throws IOException {
    }

    @Test(description = "This test asserts page title, adds contacts and check that appropriate contacts were added")
    public void simpleTestsOnNativeApplication() {
        HomePage homePage = new HomePage(driver);
        //Assert that page has expected title
        assertEquals(homePage.getTitleText(), "Contact Manager");
        //Click AddContact button to add contact
        homePage.clickAddContactButton();
        AddContactPage contactPage = new AddContactPage(driver);
        //Add first contact parameters
        contactPage.addContact(ContactNames.USER_1, ContactNumbers.USER_1);
        //Click AddContact button to add contact
        homePage.clickAddContactButton();
        //Add second contact parameters
        contactPage.addContact(ContactNames.USER_2, ContactNumbers.USER_2);
        //Click AddContact button to add contact
        homePage.clickAddContactButton();
        //Add third contact parameters
        contactPage.addContact(ContactNames.USER_3, ContactNumbers.USER_3);
        //Assert that added contacts are in contact list
        assertThat(homePage.getStringContactList(), hasItem(ContactNames.USER_1.getName()));
        assertThat(homePage.getStringContactList(), hasItem(ContactNames.USER_2.getName()));
        assertThat(homePage.getStringContactList(), hasItem(ContactNames.USER_3.getName()));

    }

}



