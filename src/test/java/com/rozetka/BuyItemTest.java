package com.rozetka;

import com.google.core.WebDriverTestBase;
import com.rozetka.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyItemTest extends WebDriverTestBase{
    @Test
    public void searchGood() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.searchForItem("iphone"));
    }
}
