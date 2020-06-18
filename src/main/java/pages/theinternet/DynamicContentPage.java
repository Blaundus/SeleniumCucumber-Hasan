package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicContentPage {

    private WebDriver driver;

    By btn = By.cssSelector("#checkbox-example button");
    By checkbox = By.id("checkbox");
    By message = By.id("message");

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicContentPage clickBtn() {
        driver.findElement(btn).click();
        return this;
    }

    public String getMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));

        return driver.findElement(message).getText();
    }

}
