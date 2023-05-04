import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleFormDemo {
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

    @Test (priority = 1)
    public void singleInputField() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys("test");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(true, yourMessage.isDisplayed());
    }
    @Test
    public void checkThatTheInputFieldIsEmpty(){
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(false, yourMessage.isDisplayed());
    }

    @Test (priority = 2)
    public void twoInputFields() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("3");
        driver.findElement(By.id("sum2")).sendKeys("23");
        driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/form/button")).click();
        WebElement yourValue = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(26, 26);

    }
}
