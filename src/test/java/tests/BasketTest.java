package tests;

import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasketPage;
@Listeners(TestListener.class)
public class BasketTest extends BaseTest{

    BasketPage basketPage;

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addToCartTest(){
        basketPage = new BasketPage(driver);
        basketPage.addProductsToBasket();
        Assert.assertTrue(basketPage.priceCalculation());
    }


}
