package TheInternetTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.theinternet.DropdownPage;
import pages.theinternet.LoginPage;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends BaseTest {

    DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        dropdownPage = new DropdownPage(driver);

        dropdownPage.navigateTo();
    }

    @Test
    public void secondOption_Oprion2() {
        String expected = "Option 2";

        String selectedption = dropdownPage.selectOption(2).getSelectedOption();

        assertEquals(selectedption, expected, "Wrong option");
    }
}
