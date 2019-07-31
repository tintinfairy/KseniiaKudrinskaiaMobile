package pages.voids.pagesForNativeApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.voids.base.BasePageForNative;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePageForNative {

    @FindBy(id = "addContactButton")
    private WebElement addContactButton;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "contactEntryText")
    private List<WebElement> contactList;


    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickAddContactButton() {
        addContactButton.click();
    }

    public String getTitleText() {
        return title.getText();
    }

    public List<String> getStringContactList() {
        return contactList.stream().map(s -> s.getText()).collect(Collectors.toList());
    }


}
