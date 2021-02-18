package com.gmail.shulgin220618;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement waitElement(By locator, int n){
        WebDriverWait wait = new WebDriverWait(driver, n);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
