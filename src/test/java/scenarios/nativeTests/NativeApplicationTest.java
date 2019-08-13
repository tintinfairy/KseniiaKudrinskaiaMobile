package scenarios.nativeTests;

import base.BaseTestHooks;
import enums.ContactNames;
import enums.ContactNumbers;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pages.voids.pagesForNativeApp.AddContactPage;
import pages.voids.pagesForNativeApp.HomePage;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Test class
 * With PageObject Pattern implementation
 */
public class NativeApplicationTest extends BaseTestHooks {
    public NativeApplicationTest() throws IOException {
    }

    @Test(description = "This test asserts page title, adds contacts and check that appropriate contacts were added")
    public void simpleTestsOnNativeApplication() {
        HomePage homePage = new HomePage();
        //Assert that page has expected title
        assertEquals(homePage.getTitleText(), "Contact Manager");
        //Click AddContact button to add contact
        homePage.clickAddContactButton();
        AddContactPage contactPage = new AddContactPage();

        //Add first contact parameters
        contactPage.addContact(ContactNames.USER_1, ContactNumbers.USER_1);
        //Checking that keyboard appears
        assertTrue(((AndroidDriver) driver).isKeyboardShown());
        //Click Save button
        contactPage.clickSaveButton();


        //Click AddContact button to add contact
        homePage.clickAddContactButton();
        //Add second contact parameters
        contactPage.addContact(ContactNames.USER_2, ContactNumbers.USER_2);
        //Checking that keyboard appears
        assertTrue(((AndroidDriver) driver).isKeyboardShown());
        //Click Save button
        contactPage.clickSaveButton();


        //Click AddContact button to add contact
        homePage.clickAddContactButton();
        //Add third contact parameters
        contactPage.addContact(ContactNames.USER_3, ContactNumbers.USER_3);
        //Checking that keyboard appears
        assertTrue(((AndroidDriver) driver).isKeyboardShown());
        //Click Save button
        contactPage.clickSaveButton();


        //Assert that added contacts are in contact list
        assertTrue(homePage.checkIfContactsAreShown(ContactNames.USER_1));
        assertTrue(homePage.checkIfContactsAreShown(ContactNames.USER_2));
        assertTrue(homePage.checkIfContactsAreShown(ContactNames.USER_3));

    }

}