package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtn = By.cssSelector("#login > button");
    By message = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void login(String user, String pass) {
        driver.findElement(userLocator).sendKeys(user);
        driver.findElement(passwordLocator).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    public LoginPage loginWrongCredentials (String user, String pass){
        login(user, pass);
        return this;
    }


    public SecurePage loginRightCredentials (String user, String pass){
        login(user, pass);
        return new SecurePage(this.driver);
    }

    public String getMessage(){
        return driver.findElement(message).getText();
    }

}
