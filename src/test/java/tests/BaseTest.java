package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupMethods() throws InterruptedException {
        //WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //driver.get("https://the-internet.herokuapp.com/login");
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    WebElement getElement(By locator){
        WebElement element = driver.findElement(locator);
        return element;
    }

    void typeIn(By locator, String input){
        getElement(locator).sendKeys(input);
    }

    void clickOnElement(By locator){
        getElement(locator).click();
    }

    String getTextFromElement(By locator){
        return getElement(locator).getText();
    }



}
