package steps.nativeApp;

import base.BaseTestHooks;
import enums.ContactNames;
import enums.ContactNumbers;
import pages.voids.pagesForNativeApp.AddContactPage;

import java.io.IOException;

/**
 * Test class
 * With Steps Pattern implementation
 */
public class AddContactPageSteps extends BaseTestHooks {
    AddContactPage contactPage;
    public AddContactPageSteps() throws IOException {
        contactPage = new AddContactPage(driver);
    }


    public void addContact(ContactNames name, ContactNumbers telNumber){
        contactPage.addContact(name, telNumber);
    }
}
