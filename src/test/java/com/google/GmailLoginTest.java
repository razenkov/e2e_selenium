package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLoginTest {
    private WebElement emailFieldWE;
    private WebElement nextButton;
    private WebElement passField;
    private WebElement doneWE;
    private WebElement icon;
    private WebElement emailWE;

    private By loc_emailField = By.id("identifierId");
    private By loc_nextBtn = By.id("identifierNext");
    private By loc_passwordField = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    private By loc_doneBtn = By.cssSelector("#yDmH0d");
    private By loc_AccountIcon = By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[1]/a/span");
    private By loc_email = By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div");

    @Test
    public void loginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://mail.google.com/mail");
        driver.manage().window().maximize();

        emailFieldWE = driver.findElement(loc_emailField);
        emailFieldWE.sendKeys("storagestorage015@gmail.com");
        nextButton = driver.findElement(loc_nextBtn);
        nextButton.click();
        passField = driver.findElement(loc_passwordField);
        passField.sendKeys("99Francs");
        passField.sendKeys(Keys.ENTER);
        doneWE = driver.findElement(loc_doneBtn);
        doneWE.click();
        icon = driver.findElement(loc_AccountIcon);
        icon.click();
        emailWE = driver.findElement(loc_email);
        Assert.assertTrue(emailWE.getText().contains("storagestorage015@gmail.com"));
        driver.close();
    }
}

