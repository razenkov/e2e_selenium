package com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By loc_searchField = By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input");
    private By loc_searchButton = By.xpath("//*[@id='rz-search']/form/span/span/button");
    private By loc_iphoneTitle = By.xpath("//*[@id='catalog_goods_block']/div/div[1]/div[1]/div/div[1]/div[2]/div[4]/a");
    private By loc_buyButton = By.xpath("//*[@id='detail_buy_label']/div[4]/div[1]/div/form/span/span/button");
    private By loc_checkoutBtn = By.xpath("//*[@id='popup-checkout']");

    private WebElement searchField;
    private WebElement checkOutBtn;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean searchForItem(String nameOfItem) throws InterruptedException{
        driver.get("https://rozetka.com.ua");
        driver.manage().window().maximize();
        searchField = driver.findElement(loc_searchField);
        searchField.click();
        searchField.sendKeys(nameOfItem);

        driver.findElement(loc_searchButton).click();
        driver.findElement(loc_iphoneTitle).click();
        driver.findElement(loc_buyButton).click();

        checkOutBtn = driver.findElement(loc_checkoutBtn);
        return checkOutBtn.isDisplayed();
    }

}
