package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    WebDriver driver;

    By dropdownLocator = By.id("dropdown");

    String URL = "https://the-internet.herokuapp.com/dropdown";

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownPage navigateTo(){
        driver.get(URL);
        return  this;
    }

    public DropdownPage selectOption(int index) {
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByIndex(index);
        return this;
    }

    public String getSelectedOption() {
        Select dropdown = new Select(driver.findElement(dropdownLocator));
        return dropdown.getFirstSelectedOption().getText();
    }
}
