package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    private long waitTime = Long.parseLong(Utils.dotenv().get("EXPLICIT_WAIT_TIME"));

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));//explicit
    }


    WebElement getElement(By locator){
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            logger.info("Element found: " + element.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


        return element;
    }

    void typeIn(By locator, String input){
        getElement(locator).sendKeys(input);
    }

    void clickOnElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try {
             wait.until(ExpectedConditions.elementToBeClickable(locator));
             logger.info("Successfully clicked on: " + locator.toString());
        }catch (ElementClickInterceptedException e){
            logger.warn("ElementClickInterceptedException occured!");
            hoverAndClick(locator);
        }catch (TimeoutException te){
            logger.warn("TimeoutException occured!");
            getElement(locator).click();
        }catch (StaleElementReferenceException st) {
            logger.warn("Stale element error occured!");
            WebElement element = getElement(locator);
            js.executeScript("arguments[0].click()", element);
        }catch (Exception e){
           e.printStackTrace();
           logger.error("FAILED - Unable to click on element: " + locator.toString());
        }
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
