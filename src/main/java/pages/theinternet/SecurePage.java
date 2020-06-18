package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    WebDriver driver;

    By message = By.id("flash");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage(){
        return driver.findElement(message).getText();
    }
}
