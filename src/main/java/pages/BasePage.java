package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));//explicit
    }


    WebElement getElement(By locator){
        //new ChromeDriver().findElement(locator);
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

    List<WebElement> getElements(By locator){
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }


    public void clickOnRandomElementFromList(By locator){
        Random random = new Random();
        List<WebElement> list = driver.findElements(locator);
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    public void hover(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator))
                .perform();
    }

    public void hoverAndClick(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator))
                .click()
                .perform();
    }







}
