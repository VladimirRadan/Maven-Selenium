package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumActions extends BaseTest{



    @Test
    public void iFrameTest(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.id("sampleHeading"));
        String text = element.getText();
        System.out.println(text);
    }

    @Test
    public void sliderTest() throws InterruptedException {
        driver.get("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.cssSelector(".range-slider"));
        for (int i = 0; i < 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Thread.sleep(4000);
    }

    @Test
    public void tabsTest() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        String currentTab = driver.getWindowHandle();
        System.out.println(currentTab);

        WebElement clickOnNewTab = driver.findElement(By.id("tabButton"));
        clickOnNewTab.click();
        Thread.sleep(3000);
        Set set = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(set);
        driver.switchTo().window(tabs.get(1));

        WebElement textElement = driver.findElement(By.id("sampleHeading"));
        String text = textElement.getText();
        System.out.println(text);
        driver.close();
        //driver.quit();
    }








}
