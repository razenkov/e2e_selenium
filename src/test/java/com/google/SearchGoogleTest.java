package com.google;

import com.google.core.WebDriverTestBase;
import com.google.pages.GoogleMailLoginPage;
import com.google.pages.GoogleResultPage;
import com.google.pages.GoogleSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchGoogleTest extends WebDriverTestBase {
    private By searchF = By.name("q");
    private By firstLink = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private WebElement searchField;
    private WebElement link;
    private String text = "Selenium";
    private String searchData = "Selenium";

    @Test
    public void searchGoogleTest(){
        driver.get("https://www.google.com.ua/");
        driver.manage().window().maximize();
        searchField = driver.findElement(searchF);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchField.sendKeys("selenium");
        searchField.submit();
        link = driver.findElement(firstLink);
        List<WebElement> list;
        list = driver.findElements(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div/h3/a"));

        for (int i = 0; i < list.size(); ++i){
            Assert.assertTrue(list.get(i).getText().contains(searchData));
        }
    }

    @Test
    public void searchGooglePageTest(){
        driver.get("https://www.google.com.ua/");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.searchFor(text);
        GoogleResultPage resultPage = new GoogleResultPage(driver);

        Assert.assertTrue(resultPage.findLink().getText().contains(searchData));
    }

    @Test
    public void loginTest(){
        driver.get("https://mail.google.com/mail");
        driver.manage().window().maximize();

        GoogleMailLoginPage googleGmailLoginPage = new GoogleMailLoginPage();
        googleGmailLoginPage.login(driver);
        Assert.assertEquals(googleGmailLoginPage.isLogIn(driver),true);
    }

}
