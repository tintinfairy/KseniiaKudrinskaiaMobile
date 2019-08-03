package scenarios.nativeTests;

import base.BaseTestHooks;
import enums.ContactNames;
import enums.ContactNumbers;
import org.testng.annotations.Test;
import steps.nativeApp.AddContactPageSteps;
import steps.nativeApp.HomePageSteps;

import java.io.IOException;

/**
 * Test class
 * With PageObject Pattern implementation
 */
public class NativeApplicationTest extends BaseTestHooks {
    public NativeApplicationTest() throws IOException {
    }

    @Test(description = "This test asserts page title, adds contacts and check that appropriate contacts were added")
    public void simpleTestsOnNativeApplication() throws IOException {
        HomePageSteps homePageSteps = new HomePageSteps();
        //Assert that page has expected title
        homePageSteps.expectedTitleAssertion("Contact Manager");
        //Click AddContact button to add contact
        homePageSteps.clickContactButton();
        AddContactPageSteps contactPageSteps = new AddContactPageSteps();
        //Add first contact parameters
        contactPageSteps.addContact(ContactNames.USER_1, ContactNumbers.USER_1);
        //Click AddContact button to add contact
        homePageSteps.clickContactButton();
        //Add second contact parameters
        contactPageSteps.addContact(ContactNames.USER_2, ContactNumbers.USER_2);
        //Click AddContact button to add contact
        homePageSteps.clickContactButton();
        //Add third contact parameters
        contactPageSteps.addContact(ContactNames.USER_3, ContactNumbers.USER_3);
        //Assert that added contacts are in contact list
        homePageSteps.chosenContactIsAdded(ContactNames.USER_1);
        homePageSteps.chosenContactIsAdded(ContactNames.USER_2);
        homePageSteps.chosenContactIsAdded(ContactNames.USER_3);

    }

}



