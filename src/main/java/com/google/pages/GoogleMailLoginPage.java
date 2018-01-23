package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMailLoginPage {
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

    public void login(WebDriver driver){
        emailFieldWE = driver.findElement(loc_emailField);
        emailFieldWE.sendKeys("razenkov.slava@gmail.com");
        nextButton = driver.findElement(loc_nextBtn);
        nextButton.click();
        passField = driver.findElement(loc_passwordField);
        passField.sendKeys("TooToo7772121RazE");
        passField.sendKeys(Keys.ENTER);
        doneWE = driver.findElement(loc_doneBtn);
        doneWE.click();
    }

    public boolean isLogIn(WebDriver driver){
        icon = driver.findElement(loc_AccountIcon);
        icon.click();
        emailWE = driver.findElement(loc_email);
        return emailWE.getText().contains("razenkov.slava@gmail.com");
    }

}
