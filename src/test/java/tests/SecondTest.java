package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest{


    @Test
    public void secondTest(){

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
