package com.gmail.shulgin220618;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class CatalogPage {
    public WebDriver driver;

    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLoadMore(){
        try {
            while (true) {
                waitShowButtonLoadMore(By.xpath("//button[@class=\"btn btn-lg btn-primary btn--tiles-more btn--pagination\"]"), 5).click();
            }
        }catch(Exception e){
            System.out.println("Загружены все элементы");
        }
    }

    private WebElement waitShowButtonLoadMore(By locator, int n){
        WebDriverWait wait = new WebDriverWait(driver, n);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private List<WebElement> getAllCategories(){
        return driver.findElements(By.xpath("//*[@class=\"t-modal-layout-item g-tile g-tile--3\"]"));
    }

    public List<String> getLinksCategories(){
        String link = "https://gosuslugi29.ru/pgu/categories/info.htm?id=";
        List<String> links = new ArrayList<String>();
        List<WebElement> allCategories = getAllCategories();
        for (WebElement category : allCategories){
            links.add(link + category.getAttribute("data-objid"));
        }
        return links;
    }
}
