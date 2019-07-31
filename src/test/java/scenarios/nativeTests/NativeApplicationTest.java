package scenarios.nativeTests;

import base.BaseTestHooks;
import org.testng.annotations.Test;
import pages.voids.pagesForNativeApp.HomePage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class NativeApplicationTest extends BaseTestHooks {
    public NativeApplicationTest() throws IOException {
    }

    HomePage homePage = new HomePage(driver);

    @Test
    public void simpleTestsOnNativeApplication() {
        assertEquals(homePage.getTitleText(), "Contact Manager");
        homePage.clickAddContactButton();
    }

}



