import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumExecution {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

        WebDriver driver = new ChromeDriver();

        //WebDriver driver = new FirefoxDriver();

        //driver.manage().window().setSize(new Dimension(320,300));

        //driver.manage().window().maximize();


        driver.get("https://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Selenium");

        driver.findElement(By.id("search_button_homepage")).click();

        Thread.sleep(5000);

        driver.close();
    }
}
