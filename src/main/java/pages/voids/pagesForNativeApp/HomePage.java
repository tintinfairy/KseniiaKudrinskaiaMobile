package pages.voids.pagesForNativeApp;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.voids.base.BasePageForNative;

public class HomePage extends BasePageForNative {

    @FindBy(id = "addContactButton")
    private WebElement addContactButton;

    @FindBy(id = "title")
    @Getter
    private WebElement title;


    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickAddContactButton() {
        addContactButton.click();
    }

    public String getTitleText() {
        return title.getText();
    }


}
