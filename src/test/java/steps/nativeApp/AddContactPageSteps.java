package steps.nativeApp;

import base.BaseTestHooks;
import enums.ContactNames;
import enums.ContactNumbers;
import io.appium.java_client.android.AndroidDriver;
import pages.voids.pagesForNativeApp.AddContactPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Test class
 * With Steps Pattern implementation
 */
public class AddContactPageSteps extends BaseTestHooks {
    AddContactPage contactPage;

    public AddContactPageSteps() throws IOException {
        contactPage = new AddContactPage();
    }

    public void keyboardAppearanceAssertion(){
        assertTrue(((AndroidDriver) driver).isKeyboardShown());
    }

    public void addContact(ContactNames name, ContactNumbers telNumber) {
        contactPage.addContact(name, telNumber);
    }

    public void clickSaveButton(){
        contactPage.clickSaveButton();
    }
}
