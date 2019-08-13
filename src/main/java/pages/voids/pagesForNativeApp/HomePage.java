package pages.voids.pagesForNativeApp;

import enums.ContactNames;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.voids.base.BasePageForNative;
import setup.DriverSetup;

import java.time.Duration;
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


    public void scrollDown() {
        Dimension dimension = DriverSetup.getDriver().manage().window().getSize();
        int startScrollPoint = dimension.height / 2;
        int endScrollPoint = dimension.height / 5;
        int waitTime = 6;
        new TouchAction(DriverSetup.getDriver())
                .press(PointOption.point(0, startScrollPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(waitTime)))
                .moveTo(PointOption.point(0, endScrollPoint))
                .release()
                .perform();
    }

    public List<String> getStringContactList() {
        scrollDown();
        return contactList.stream().map(s -> s.getText()).collect(Collectors.toList());
    }

    public boolean checkIfContactsAreShown(ContactNames name) {
        if (!getStringContactList().contains(name.getName())) {
            showInvisibleCheck.click();
            checkIfContactsAreShown(name);
        }
        return true;
    }

}