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

public class NativeApplicationTest extends BaseTestHooks {
    public NativeApplicationTest() throws IOException {
    }

    @Test
    public void simpleTestsOnNativeApplication() {
        HomePage homePage = new HomePage(driver);
        assertEquals(homePage.getTitleText(), "Contact Manager");
        homePage.clickAddContactButton();
        AddContactPage contactPage = new AddContactPage(driver);
        contactPage.addContact(ContactNames.USER_1, ContactNumbers.USER_1);
        homePage.clickAddContactButton();
        contactPage.addContact(ContactNames.USER_2, ContactNumbers.USER_2);
        homePage.clickAddContactButton();
        contactPage.addContact(ContactNames.USER_3, ContactNumbers.USER_3);
        assertThat(homePage.getStringContactList(), hasItem(ContactNames.USER_1.getName()));
        assertThat(homePage.getStringContactList(), hasItem(ContactNames.USER_2.getName()));
        assertThat(homePage.getStringContactList(), hasItem(ContactNames.USER_3.getName()));

    }

}



