package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {


    //By registerLink = By.linkText("Register");
    //By registerLink = By.xpath("//a[@class='ico-register']");
    By registerLink = By.xpath("//a[text()='Register']");
    By selectGender = By.xpath("//input[@value='M']");
    By firstNameField = By.id("FirstName");
    By lastNameField = By.name("LastName");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmPasswordField = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    By registeredUserText = By.cssSelector(".page-body > .result");
    By continueButton = By.xpath("//div[@class='page-body']/div[2]/input");

    // /html/body/div[5]/div[1]/div[4]/div[3]/form/div/div[2]/div[2]/div[2]/div[1]/div[1]/input --> apsolutni lokator


    @Test(description = "Verifying register user test - Expected: User is registered and is on profile page")
    public void registerUserTest() {
        clickOnElement(registerLink);
        clickOnElement(selectGender);
        typeIn(firstNameField, "John");
        typeIn(lastNameField, "Smith");
        typeIn(emailField, "johntest801@test.com");
        typeIn(passwordField, "testing");
        typeIn(confirmPasswordField, "testing");
        clickOnElement(registerButton);

        String expectedText = "Your registration completed";
        String actualText = getTextFromElement(registeredUserText);
        Assert.assertEquals(actualText, expectedText);

        boolean isButtonPresentOnPage = getElement(continueButton).isDisplayed();
        Assert.assertTrue(isButtonPresentOnPage);
    }


}
