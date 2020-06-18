package TheInternetTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.theinternet.DynamicContentPage;
import pages.theinternet.LoginPage;

import static org.testng.Assert.assertEquals;

public class DynamicControlTest extends BaseTest{
    DynamicContentPage dynamicContentPage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        dynamicContentPage = new DynamicContentPage(driver);
    }

    @Test
    public void clickButton_MessageApear() {
        String expectedMessage = "It's gone!";
        dynamicContentPage.clickBtn();

        String message = dynamicContentPage.getMessage();

        assertEquals(message,expectedMessage,"Wrong Message");
    }
}
