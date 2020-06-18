package TheInternetTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
