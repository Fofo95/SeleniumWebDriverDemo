import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GoogleSearchTest  {

    public String baseUrl= "http://www.google.com/";
    public WebDriver driver = new ChromeDriver();

    @Test
    public void verifyHomePageTitle() {
        driver.get(baseUrl);
        //Accept cookies
        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys("Cheese!");
        element.submit();
        element = driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div[1]/div[1]/div[2]/div/div[3]/div[1]"));
        element.click();

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        //driver.quit();
    }
}