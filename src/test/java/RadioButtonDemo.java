import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonDemo {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\florin.stefan\\Desktop\\fasttrackit\\QA 32\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /*@AfterClass
    public void teardown() {
        driver.quit();
    }*/


    @Test
    public void radioButtonDemo() {
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");

        // find the checkbox elements by name
        WebElement checkbox1 = driver.findElement(By.xpath("/html/body/div[1]/div/section[3]/div/div/div[2]/div[1]/div[2]/label[1]/input"));
        checkbox1.click();


        // verify that the checkboxes are checked after clicking them
        Assert.assertTrue(checkbox1.isSelected());

    }
}
