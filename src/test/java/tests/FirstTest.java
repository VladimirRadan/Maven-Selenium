package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{


    @BeforeClass
    public void setup(){
        System.out.println("Before class");
    }


    @Test
    public void firstTest() {

        WebElement usernameField = driver.findElement(By.cssSelector("input[name='username']"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //WebElement passwordField1 = driver.findElement(By.cssSelector("#password"));

        WebElement loginButton = driver.findElement(By.cssSelector(".fa"));
        loginButton.click();

        WebElement loggedInText = driver.findElement(By.id("flash"));

        String actualColor = loggedInText.getCssValue("background-color");

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].style.background='red'", loggedInText);

        String expectedColor = "rgba(93, 164, 35, 1)";
        Assert.assertEquals(actualColor, expectedColor);//hard assert

    }









}
