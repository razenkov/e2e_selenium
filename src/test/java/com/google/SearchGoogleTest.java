package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchGoogleTest {
    private WebDriver driver;
    private By searchF = By.name("q");
    private By firstLink = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");

    private WebElement searchField;
    private WebElement link;
    private String resultLink = "Selenium";
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

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
            Assert.assertTrue(list.get(i).getText().contains(resultLink));
        }
        driver.close();
    }
}
