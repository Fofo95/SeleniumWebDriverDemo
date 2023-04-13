import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestsWithAllLocators {


    //===Id Selector===
    @Test
    public void testByIdSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("Selenium WebDriver");
        element.submit();
        Assert.assertEquals("Selenium WebDriver", driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value"));
        driver.quit();
    }

    //===Name Selector===
    @Test
    public void testByNameSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //Accept cookies
        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
        driver.quit();
    }

    //===Class Selector===
    @Test
    public void testByClassSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        WebElement cookies = driver.findElement(By.id("accept-choices"));
        cookies.click();
        WebElement element = driver.findElement(By.className("w3-bar-item"));
        element.click();
        Assert.assertEquals("https://www.w3schools.com/", driver.getCurrentUrl());
       driver.quit();
    }

    //===Tag Name Selector ===
    @Test
    public void testByTagNameSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        Assert.assertTrue(elements.size() > 0);
        driver.quit();
    }

    //===Link Text Selector===
    @Test
    public void testByLinkTextSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.linkText("Downloads"));
        element.click();
        Assert.assertEquals("https://www.selenium.dev/downloads/", driver.getCurrentUrl());
        driver.quit();
    }


    //===Partial Link Text Selector===
    @Test
    public void testByPartialLinkTextSelector() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.github.com/");
        WebElement element = driver.findElement(By.partialLinkText("Explore"));
        element.click();
        Assert.assertEquals("https://github.com/", driver.getCurrentUrl());
        driver.quit();
    }
}
