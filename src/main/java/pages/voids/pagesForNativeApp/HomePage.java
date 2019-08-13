package pages.voids.pagesForNativeApp;

import enums.ContactNames;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.voids.base.BasePageForNative;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Page to implement PageObject Pattern for Native App
 * Includes elements search and actions with them
 */


public class HomePage extends BasePageForNative {

    @FindBy(id = "addContactButton")
    private WebElement addContactButton;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "contactEntryText")
    private List<WebElement> contactList;

    @FindBy(id = "showInvisible")
    private WebElement showInvisibleCheck;


    public void clickAddContactButton() {
        addContactButton.click();
    }

    public String getTitleText() {
        return title.getText();
    }

    public List<String> getStringContactList() {

        return contactList.stream().map(s -> s.getText()).collect(Collectors.toList());
    }


    public void checkIfContactIsInvisible(ContactNames name) {
        if (!getStringContactList().contains(name.getName())) {
            showInvisibleCheck.click();
        }
    }

}