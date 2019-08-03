package pages.voids.pagesForNativeApp;

import enums.ContactNames;
import enums.ContactNumbers;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.voids.base.BasePageForNative;

/**
 * Page to implement PageObject Pattern for Native App
 * Includes elements search and actions with them
 */
public class AddContactPage extends BasePageForNative {

    @FindBy(id = "contactNameEditText")
    private WebElement contactNameField;

    @FindBy(id = "contactPhoneEditText")
    private WebElement contactPhoneField;

    @FindBy(id = "contactSaveButton")
    private WebElement saveButton;

    public AddContactPage(AppiumDriver driver) {
        super(driver);
    }


    public void fillInContactNameField(ContactNames name) {
        contactNameField.sendKeys(name.getName());
    }

    public void fillInContactPhoneField(ContactNumbers telNumber) {
        contactPhoneField.sendKeys(telNumber.getTelNumber());
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void addContact(ContactNames name, ContactNumbers telNumber) {
        fillInContactNameField(name);
        fillInContactPhoneField(telNumber);
        clickSaveButton();
    }


}