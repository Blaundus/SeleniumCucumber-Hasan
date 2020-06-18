package TheInternetTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.theinternet.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testWrongCredentials_ShouldntLetMeIn() {

        String user = "fake";
        String password = "fake";
        String expectedMessage = "Your username is invalid!";

        String message = loginPage
                .loginWrongCredentials(user, password)
                .getMessage();

        assertTrue(message.contains(expectedMessage), "Message is not correct");

        assertTrue(driver.getCurrentUrl().endsWith("login"), "We are not in the rigth page");

    }

    @Test
    public void testRightCredentials_ShouldLetMeIn() {

        String user = "tomsmith";
        String password = "SuperSecretPassword!";
        String expectedMessage = "You logged into a secure area!";

        String message = loginPage
                .loginRightCredentials(user, password)
                .getMessage();

        assertTrue(message.contains(expectedMessage), "Message is not correct");

        assertTrue(driver.getCurrentUrl().endsWith("secure"), "We are not in the rigth page");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
