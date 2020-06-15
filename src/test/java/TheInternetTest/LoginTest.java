package TheInternetTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testWrongCredentials_ShouldntLetMeIn() {

        String user = "fake";
        String password = "fake";
        String expectedMessage = "Your username is invalid!";

        driver.findElement(By.id("username")).sendKeys(user);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.cssSelector("#login > button")).click();

        final String message = driver.findElement(By.id("flash")).getText();

        assertTrue(message.contains(expectedMessage), "Message is not correct");

        assertTrue(driver.getCurrentUrl().endsWith("login"), "We are not in the rigth page");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
