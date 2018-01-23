package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GoogleSearchPage {
    private WebDriver driver;

    private By searchF = By.name("q");
    private By firstLink = By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/div/div/h3/a");
    private WebElement searchField;
    private WebElement link;
    private String resultLink = "Selenium";

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchFor(String text){
        searchField = driver.findElement(searchF);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchField.sendKeys("selenium");
        searchField.submit();
    }
}
