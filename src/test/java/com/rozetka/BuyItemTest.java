package com.rozetka;

import com.google.core.WebDriverTestBase;
import com.rozetka.pages.HomePage;
import org.testng.annotations.Test;


public class RozetkaLoginTest extends WebDriverTestBase{
    @Test
    public void searchGood() throws InterruptedException {
        //private static final String URL = "https://rozetka.com.ua";
        HomePage homePage = new HomePage(driver);
        driver.get("https://rozetka.com.ua");
        homePage.searchForItem("iphone");

        //driver.manage().window().maximize();


        //Assert.assertEquals(isCheckoutExist, true);
    }
}
