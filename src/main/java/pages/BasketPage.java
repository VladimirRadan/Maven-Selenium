package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BasePage{


    By headerMenuComputers = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By headerMenuNotebooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Notebooks')]");
    By headerMenuBooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
    By addProductToCart = By.cssSelector("input[value='Add to cart']");

    By goToCart = By.cssSelector(".ico-cart .cart-label");
    By productPrices = By.cssSelector(".product-subtotal");
    By totalAmount = By.cssSelector(".product-price > strong");


    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public void addProductsToBasket(){
        hover(headerMenuComputers);
        hoverAndClick(headerMenuNotebooks);
        clickOnElement(addProductToCart);
        clickOnElement(headerMenuBooks);
        clickOnRandomElementFromList(addProductToCart);
        clickOnElement(goToCart);
    }

    public boolean priceCalculation(){
        List<WebElement> productInCartPrices = getElements(productPrices);
        double sum = 0;
        for (int i = 0; i < productInCartPrices.size(); i++) {
            sum +=  Double.parseDouble(productInCartPrices.get(i).getText());
        }
        double total = Double.parseDouble(getElement(totalAmount).getText());
        return sum == total + 1; // dodat 1 za failovanje testa
    }








}
