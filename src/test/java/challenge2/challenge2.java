package challenge2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class challenge2 {
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
    public void searchForExotics() throws Exception{
        WebElement searchBar = driver.findElement(By.id("input-search"));
        Assert.assertTrue(searchBar.isDisplayed());
        searchBar.sendKeys("exotics");
        searchBar.sendKeys(Keys.RETURN);
    }

    @Test()
    public void verifyPorscheIsPresent() throws Exception{
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("PORSCHE"));
    }
}
