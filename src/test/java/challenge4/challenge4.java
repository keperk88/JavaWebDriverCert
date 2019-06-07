package challenge4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class challenge4 {
    public WebDriver driver;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System.out.println("All done!!!");
    }

    @BeforeClass
    public void startClass() throws Exception{
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver");
        driver =  new ChromeDriver();
    }

    @AfterClass
    public void stopClass(){
        driver.quit();
    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod(){
    }

    @Test()
    public void goToCopart() throws Exception{
        driver.get("https://www.copart.com");
        Assert.assertTrue(driver.getTitle().contains("Copart"));
    }

    @Test()
    public void printPopularItems() throws Exception{
        List<WebElement> popularItems = driver.findElements(By.xpath("//*[@id=\"tabTrending\"]/div[1]/div[2]/div/ul/li/a"));
        Assert.assertFalse(popularItems.isEmpty());
        for (WebElement e : popularItems) {
            System.out.println(e.getText() + " - " + e.getAttribute("href"));
        }
    }
}
