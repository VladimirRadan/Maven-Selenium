package tests;

import io.qameta.allure.*;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasketPage;
@Listeners(TestListener.class)
public class BasketTest extends BaseTest{

    BasketPage basketPage;

    @Test(groups = "basket")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Epic Basket")
    @Story("Adding products to basket story")
    @Description("Verifying that price calculation in basket is correct")
    public void addToCartTest(){
        basketPage = new BasketPage(driver);
        basketPage.addProductsToBasket();
        Assert.assertTrue(basketPage.priceCalculation());
    }


}
