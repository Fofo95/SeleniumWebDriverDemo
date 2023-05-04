import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MultipleWebsiteInTheSameInstance {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver instance
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test (priority = 1)
    public void verifyUserNameAndPassWithValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //Accept cookies
        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }

    @Test
    public void verifyUserNameAndPassWithInvalidCredentials() {
        // Navigate to website 2
        driver.get("https://www.amazon.com/");
        // Perform some actions on website 2
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("Java Programming");
        element.submit();
        Assert.assertTrue(driver.getTitle().contains("Java Programming"));
    }

    @Test
    public void testWebsite3() {
        // Navigate to website 3
        driver.get("https://www.linkedin.com/");
        WebElement signInButton = driver.findElement(By.xpath("//a[@data-tracking-control-name='guest_homepage-basic_nav-header-signin']"));
        signInButton.click();
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("myemail@example.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("mypassword");
        passwordField.submit();
        WebElement profileLink = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("error-for-password")));
        Assert.assertTrue(profileLink.isDisplayed());
    }

}
