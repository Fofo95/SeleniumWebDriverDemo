
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SimpleTest {
        @Test()
        public void site_header_is_on_home_page() {
            WebDriver driver = new ChromeDriver();
            driver.get("http://saucelabs.com");
            WebElement header = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[1]/div[1]/div/div[2]"));
            Assert.assertTrue((header.isDisplayed()));
            driver.close();
        }
    }

