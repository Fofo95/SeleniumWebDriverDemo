import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxDemo {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\florin.stefan\\Desktop\\fasttrackit\\QA 32\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        
        driver.quit();
    }


    @Test
    public void singleCheckboxDemo() {
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");

        // find the checkbox elements by name
        WebElement checkbox1 = driver.findElement(By.id("isAgeSelected"));
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.id("ex1-check2"));
        checkbox2.click();
        WebElement checkbox3 = driver.findElement(By.id("ex1-check3"));
        checkbox3.click();

        // verify that the checkboxes are checked after clicking them
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        Assert.assertTrue(checkbox3.isSelected());
    }

    @Test
    public void checkAllButton() {
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");

        // find the checkbox elements by name
        WebElement checkbox1 = driver.findElement(By.id("ex1-check1"));
        WebElement checkbox2 = driver.findElement(By.id("ex1-check2"));
        WebElement checkbox3 = driver.findElement(By.id("ex1-check3"));
        WebElement checkbox4 = driver.findElement(By.id("ex1-check3"));

        // verify that the checkboxes are checked after clicking them
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        Assert.assertTrue(checkbox3.isSelected());
        Assert.assertTrue(checkbox4.isSelected());

        //What is the bug here?
    }
}
