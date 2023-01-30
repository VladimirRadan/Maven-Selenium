package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Utils;

import java.time.Duration;

public class DriverManager {


    private static WebDriver driver;

    private static String browser = Utils.dotenv().get("BROWSER", "chrome");

    public static WebDriver setDriver(){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        return driver;
    }


}
