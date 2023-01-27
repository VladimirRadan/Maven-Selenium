package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    By usernameField = By.cssSelector("input[name='username']");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector(".fa");
    By loggedInText = By.id("flash");



    @Test(description = "Verifying login with expected color", groups = "smoke")
    @Parameters({"username", "password"})
    public void loginFirstTest(@Optional("tomsmith") String username,@Optional("SuperSecretPassword!") String password) {
        driver.get("https://the-internet.herokuapp.com/login");
        //WebElement usernameField = driver.findElement(By.cssSelector("input[name='username']"));
        //usernameField.sendKeys("tomsmith");
        //getElement(usernameField).sendKeys("tomsmith");
//        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
//        typeIn(usernameField, username);

//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("SuperSecretPassword!");
//        typeIn(passwordField, password);
//
//
////        WebElement loginButton = driver.findElement(By.cssSelector(".fa"));
////        loginButton.click();
//        clickOnElement(loginButton);

        //WebElement loggedInText = driver.findElement(By.id("flash"));

        //String actualColor = getElement(loggedInText).getCssValue("background-color");

        String expectedColor = null;

        if (driver instanceof ChromeDriver){
            expectedColor = "rgba(93, 164, 35, 1)";
        } else if (driver instanceof FirefoxDriver) {
            expectedColor = "rgb(93, 164, 35)";
        }


        //Assert.assertEquals(actualColor, expectedColor);//hard assert

    }

    @Test(description = "Verifying login with expected text")
    public void loginSecondTest(){
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameField =  driver.findElement(By.cssSelector("input[name='username']"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //WebElement passwordField1 = driver.findElement(By.cssSelector("#password"));

        WebElement loginButton = driver.findElement(By.cssSelector(".fa"));
        loginButton.click();

        WebElement loggedInText = driver.findElement(By.id("flash"));
        String expectedText = "You logged into a secure area!";
        String actualText3[] = loggedInText.getText().split("(?<=!)");

        Assert.assertEquals(actualText3[0],expectedText);

    }









}
